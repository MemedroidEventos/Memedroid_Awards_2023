import { alfabeto } from "./obj.js"

export  function addUserInList(userList){


    alfabeto.forEach(element =>{
        userList.innerHTML += userHTML(element.indexOf,element,img)
    
    })

}
 
export function closeVoted(){
  document.querySelector('.div-response p').style.backgroundColor = 'transparent'
  document.querySelector('.div-response p').innerText = ``

}
