/**
 * 
 */
console.log("read.js...");
const path='${pageContext.request.contextPath}';


const replyAddBtn = document.querySelector(".reply-add-btn");

replyAddBtn.addEventListener('click',()=>{
	
	axios
		.get(`${path}book/reply/create`)
		.then((resp)=>{console.log(resp);})
		.catch((error)=>{console.log(error);})
		
		
	//createReplyItem();
	
})

function createReplyItem(){
	const itemEl = document.createElement('div');
	itemEl.className='item';
	
	
	
	const leftEl = document.createElement('div');
	leftEl.className='left';
	const profileEl = document.createElement('div');
	profileEl.className='profile';
	const usernameEl = document.createElement('div');
	usernameEl.className='username';
	usernameEl.innerHTML='username';
	const rightEl = document.createElement('div');
	rightEl.className='right';
	
	const dateEl = document.createElement('div');
	dateEl.className='date';
	dateEl.innerHTML='2025-01-01';
	const contentEl = document.createElement('div');
	contentEl.className='content';
	
	const textAreaEl = document.createElement('textarea');
	
	const buttonGroupEl = document.createElement('div');
	buttonGroupEl.className='buttonGroup';	
	//연결
	leftEl.appendChild(profileEl);
	leftEl.appendChild(usernameEl);
	
	
	contentEl.appendChild(textAreaEl);
	rightEl.appendChild(dateEl);
	rightEl.appendChild(contentEl);
	rightEl.appendChild(buttonGroupEl);
	
	itemEl.appendChild(leftEl);
	itemEl.appendChild(rightEl);
	
	const itemsEl = document.querySelector('.items');
	itemsEl.appendChild(itemEl);
	
	
}