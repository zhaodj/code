package org.zhaodj.security;

public class HTMLInputFilterTest {

	public static void main(String[] args) {
		String text = "我是黑皮肤mm，真心黑，那些只是因为去个海边啊得瑟了一下啊才晒红那么一点点的妹纸们，可以主动积极的靠边吗？谢谢。<div><br></div><div><br></div><div>皮肤黑的妹纸有一个比天还大的原则要把握：肤色一定要均匀！！！大家都明白黑皮肤很容易显脏，但是却有不少黑皮肤的美人似乎有一种更慑人的性感，那么，为"
				+ "虾米不是所有黑妹纸都能有同样的气场呢？原因很多，但是最大的原因就是皮肤的质地！小麦色或者古铜色，如果皮肤光滑细腻紧致，没有不美的道理——其实一个"
				+ "人的肤质很大程度上反映了这个人有多爱自己，也就是一个人的生活态度。"
				+ "<br>"
				+ "<br><br>如果皮肤天生有些暗黄，一定要用粉底遮盖，轻薄的粉底就可以。不要信什么“男人都爱素颜”，你要是素颜跟林青霞一样美，那我也没话说；但是事实是，不少人一素颜就...自我认知是自我提升的前提！&nbsp;</div><div><br>"
				+ "<br>黑妹纸适合的颜色请参考下图：宝蓝色和藏蓝色是非常适合黑妹纸的颜色，而且一般不会出错。不过，宝蓝对气场的要求很高，如果不能驾驭，请远离！</div><div><img src=\"http://img.aibuyi.com/forum/120521/b195b89f9be044f7a426457f4ae75a7e.jpg\" style=\"font-size: 10pt; \"><span style=\"font-size: 10pt; \">宝蓝穿出味道会很惊艳！</span></div><div><br></div><div>&nbsp;</div>";
		HTMLInputFilter filter = new HTMLInputFilter(true);
		filter.filter(text);
		filter = new HTMLInputFilter(new String[]{},new String[]{},true);
		filter.filter(text);
		// filter.filter("dagdagdaf<br/>打法发噶");
		// filter.filter("<a href='/hello'><img src='http://baidu.com/adfa.jpg'></a><script type='test/javascript'>alert('dfdasfa')</script>");
	}

}
