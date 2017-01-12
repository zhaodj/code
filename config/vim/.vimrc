" Specify a directory for plugins
call plug#begin('~/.vim/plugged')

Plug 'scrooloose/nerdtree', { 'on': 'NERDTreeToggle' }

Plug 'scrooloose/syntastic'

Plug 'vim-airline/vim-airline'
Plug 'vim-airline/vim-airline-themes'

Plug 'fatih/vim-go'

Plug 'altercation/vim-colors-solarized'

Plug 'majutsushi/tagbar'

Plug 'tpope/vim-surround'

Plug 'valloric/youcompleteme'

Plug 'nathanaelkane/vim-indent-guides'

Plug 'ctrlpvim/ctrlp.vim'

Plug 'jiangmiao/auto-pairs'

" Initialize plugin system
call plug#end()

let mapleader=";"

set relativenumber
set tabstop=4
set softtabstop=4
set shiftwidth=4
"set noexpandtab
set expandtab
set list
set listchars=tab:›\ ,trail:•,extends:#,nbsp:.
set mouse=a
" 显示光标当前位置
set ruler
" 高亮显示当前行/列
set cursorline
set cursorcolumn
" 高亮搜素结果
set hlsearch

" fix mac vim delete error, so as set backspace=indent,eol,start
set backspace=2

set autoindent

set hidden
nnoremap <Leader>b :bp<CR>
nnoremap <Leader>f :bn<CR>

" Show airline all the time
set laststatus=2
"let g:airline_theme='badcat'
let g:airline#extensions#tabline#enabled=1

syntax enable
syntax on
let g:solarized_termcolors=256
set background=dark
colorscheme solarized

" 显示行号
let NERDTreeShowLineNumbers=1
let NERDTreeAutoCenter=1
" 显示隐藏文件
let NERDTreeShowHidden=1"
" 忽略一下文件的显示
let NERDTreeIgnore=['\.pyc','\~$','\.swp']
" Open NERDTree automatically when vim starts up on opening a directory
autocmd StdinReadPre * let s:std_in=1
autocmd VimEnter * if argc() == 1 && isdirectory(argv()[0]) && !exists("s:std_in") | exe 'NERDTree' argv()[0] | wincmd p | ene | endif

" Indent guides
let g:indent_guides_enable_on_vim_startup=1
let g:indent_guides_auto_colors=0
let g:indent_guides_start_level=2
let g:indent_guides_guide_size=1
autocmd VimEnter,Colorscheme * :hi IndentGuidesOdd guibg=black ctermbg=black
autocmd VimEnter,Colorscheme * :hi IndentGuidesEven guibg=darkgrey ctermbg=darkgrey

" 开启文件类型侦测
filetype on
" 自适应不同语言的智能缩进
"filetype indent on
" 根据侦测到的不同类型加载对应的插件
"filetype plugin on

" 让配置变更立即生效
"autocmd BufWritePost $MYVIMRC source $MYVIMRC

" vim 自身命令行模式智能补全
set wildmenu

if executable('ag')
  " Use Ag over Grep
  set grepprg=ag\ --nogroup\ --nocolor
  " Use ag in CtrlP for listing files.
  let g:ctrlp_user_command = 'ag %s -l --nocolor -g ""'
  " Ag is fast enough that CtrlP doesn't need to cache
  "let g:ctrlp_use_caching = 0
endif
