package org.zhaodj.disruptor;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SingleThreadedClaimStrategy;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;

public class DisruptorDemo {

	public static int RING_SIZE = 1024 * 8;
	private final ExecutorService EXECUTOR = Executors.newFixedThreadPool(1);
	private final EventHandler<ValueEvent> handler = new EventHandler<ValueEvent>() {
		public void onEvent(final ValueEvent event, final long sequence,
				final boolean endOfBatch) throws Exception {
			System.out.println(event.getValue());
		}
	};
	private Disruptor<ValueEvent> disruptor = new Disruptor<ValueEvent>(
			ValueEvent.EVENT_FACTORY, EXECUTOR,
			new SingleThreadedClaimStrategy(RING_SIZE),
			new SleepingWaitStrategy());
	RingBuffer<ValueEvent> ringBuffer;

	public DisruptorDemo() {
		disruptor.handleEventsWith(handler);
		ringBuffer = disruptor.start();
	}

	public void disruptorPass(int value) {
		// Publishers claim events in sequence
		long sequence = ringBuffer.next();
		ValueEvent event = ringBuffer.get(sequence);

		event.setValue(value); // this could be more complex with multiple
								// fields

		// make the event available to EventProcessors
		ringBuffer.publish(sequence);
	}
	
	public void halt(){
		this.disruptor.halt();
	}

	public static void main(String[] args) {
		DisruptorDemo demo = new DisruptorDemo();
		Scanner in = new Scanner(System.in);
		while(true){
			String input = in.nextLine();
			if (input.equalsIgnoreCase("bye")) {
				demo.halt();
				break;
			}
			demo.disruptorPass(Integer.valueOf(input));
		}
	}

}
