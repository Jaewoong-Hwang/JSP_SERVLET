/**
 * 
 */
console.log("read.js..");

//!!!!!! - 오류
//const path=`${pageContext.request.contextPath}`;
console.log('path : ',path)

const replyAddBtn = document.querySelector(".reply-add-btn")



replyAddBtn.addEventListener('click',()=>{
	
	const contents = document.querySelector('.reply-header textarea').value;
	axios
		.get(`${path}/book/reply/create?bookCode=${bookCode}&contents=${contents}`)
		.then((resp)=>{ 
			console.log(resp); 
			document.querySelector('.reply-header textarea').value='';
			receiveReplyData();
		})
		.catch((error)=>{ console.log(resp); })
		
	
	//createReplyItem();
})



function receiveReplyData(){
	axios
		.get(`${path}/book/reply/list?bookCode=${bookCode}`)
		.then((resp)=>{ 
			
			//기존 items의 노드제거
			const itemsEl = document.querySelector('.reply-body .items');
			while(itemsEl.firstChild){
				itemsEl.removeChild(itemsEl.firstChild)
			}
			
			console.log(resp);
			const data = resp.data; 
			const cnt = data.replyCnt;
			const replyCntEl=document.querySelector(".reply-cnt");
			replyCntEl.innerHTML=cnt;
			const items = data.replyList;			
			items.forEach(item=>createReplyItem(item))
			
		})
		.catch((error)=>{ console.log(resp); })	
}
receiveReplyData();



function createReplyItem(item){
	const itemEl = document.createElement('div');
	itemEl.className='item';
	const leftEl = document.createElement('div');
	leftEl.className='left';
	const profileEl = document.createElement('div');
	profileEl.className='profile';
	const usernameEl = document.createElement('div');
	usernameEl.className='username';
	usernameEl.innerHTML=item.username;
	const rightEl = document.createElement('div');
	rightEl.className='right';
	
	const dateEl = document.createElement('div');
	dateEl.className='date';
	dateEl.innerHTML=item.createAt;
	const contentEl = document.createElement('div');
	contentEl.className='content';
	
	const textAreaEl = document.createElement('textarea');
	textAreaEl.value=item.contents
	
	const buttonGroupEl = document.createElement('div');
	buttonGroupEl.className='button-group';
	//연결
	leftEl.appendChild(profileEl);
	leftEl.appendChild(usernameEl);
	
	contentEl.appendChild(textAreaEl);
	rightEl.appendChild(dateEl)
	rightEl.appendChild(contentEl)
	rightEl.appendChild(buttonGroupEl)
		
	itemEl.appendChild(leftEl);
	itemEl.appendChild(rightEl);
	
	const itemsEl = document.querySelector('.items');
	itemsEl.appendChild(itemEl);
}



