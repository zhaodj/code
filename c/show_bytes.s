	.section	__TEXT,__text,regular,pure_instructions
	.globl	_show_bytes
	.align	4, 0x90
_show_bytes:                            ## @show_bytes
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp3:
	.cfi_def_cfa_offset 16
Ltmp4:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp5:
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
Ltmp6:
	.cfi_offset %rbx, -40
Ltmp7:
	.cfi_offset %r14, -32
Ltmp8:
	.cfi_offset %r15, -24
	movl	%esi, %r14d
	movq	%rdi, %rbx
	testl	%r14d, %r14d
	jle	LBB0_3
## BB#1:
	leaq	L_.str(%rip), %r15
	.align	4, 0x90
LBB0_2:                                 ## %.lr.ph
                                        ## =>This Inner Loop Header: Depth=1
	movzbl	(%rbx), %esi
	movq	%r15, %rdi
	xorb	%al, %al
	callq	_printf
	incq	%rbx
	decl	%r14d
	jne	LBB0_2
LBB0_3:                                 ## %._crit_edge
	movl	$10, %edi
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	jmp	_putchar                ## TAILCALL
	.cfi_endproc

	.globl	_show_int
	.align	4, 0x90
_show_int:                              ## @show_int
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp11:
	.cfi_def_cfa_offset 16
Ltmp12:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp13:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	leaq	-4(%rbp), %rdi
	movl	$4, %esi
	callq	_show_bytes
	addq	$16, %rsp
	popq	%rbp
	ret
	.cfi_endproc

	.globl	_show_float
	.align	4, 0x90
_show_float:                            ## @show_float
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp16:
	.cfi_def_cfa_offset 16
Ltmp17:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp18:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movss	%xmm0, -4(%rbp)
	leaq	-4(%rbp), %rdi
	movl	$4, %esi
	callq	_show_bytes
	addq	$16, %rsp
	popq	%rbp
	ret
	.cfi_endproc

	.globl	_show_pointer
	.align	4, 0x90
_show_pointer:                          ## @show_pointer
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp21:
	.cfi_def_cfa_offset 16
Ltmp22:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp23:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	leaq	-8(%rbp), %rdi
	movl	$8, %esi
	callq	_show_bytes
	addq	$16, %rsp
	popq	%rbp
	ret
	.cfi_endproc

	.globl	_test_show_bytes
	.align	4, 0x90
_test_show_bytes:                       ## @test_show_bytes
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp27:
	.cfi_def_cfa_offset 16
Ltmp28:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp29:
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	pushq	%rax
Ltmp30:
	.cfi_offset %rbx, -24
	movl	%edi, %ebx
	movl	%ebx, -12(%rbp)
	callq	_show_int
	cvtsi2ssl	%ebx, %xmm0
	callq	_show_float
	leaq	-12(%rbp), %rdi
	callq	_show_pointer
	addq	$8, %rsp
	popq	%rbx
	popq	%rbp
	ret
	.cfi_endproc

	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp33:
	.cfi_def_cfa_offset 16
Ltmp34:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp35:
	.cfi_def_cfa_register %rbp
	movl	$74565, %edi            ## imm = 0x12345
	callq	_test_show_bytes
	leaq	L_.str2(%rip), %rdi
	movl	$6, %esi
	callq	_show_bytes
	xorl	%eax, %eax
	popq	%rbp
	ret
	.cfi_endproc

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	 " %.2x"

L_.str1:                                ## @.str1
	.asciz	 "\n"

L_.str2:                                ## @.str2
	.asciz	 "abcdef"


.subsections_via_symbols
