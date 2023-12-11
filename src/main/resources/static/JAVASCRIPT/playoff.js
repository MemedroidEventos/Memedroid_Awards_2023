import { divDispute } from "./codeHTML.js"

document.querySelectorAll('.div-button button').forEach( element => {
	element.addEventListener('click',()=>{
		console.log('Okay')
		document.getElementById('div-voted').style.display = 'flex'
		document.querySelector('.div-nick-vote p').innerHTML = element.getAttribute('data-username')
		document.querySelector('.div-img-perfil img').src = `https://appv2.memedroid.com/user_profile/get_user_avatar?username=${element.getAttribute('data-username')}&thumb=1`
		document.querySelector('.div-response p').innerHTML = ''
		document.querySelector('.div-response p').style.backgroundColor = 'transparent'		
	})
})
	
document.querySelectorAll('.div-user-2').forEach( element =>{
	element.addEventListener('mouseover',()=>{
			element.style.width = '60%'
			element.parentElement.querySelector('.div-user-1').style.width = '40%'
	})
	element.addEventListener('mouseout',()=>{
		element.style.width = ''
		element.parentElement.querySelector('.div-user-1').style.width = ''
			
	})
				
})

document.querySelectorAll('.div-user-1').forEach( element =>{
	element.addEventListener('mouseover',()=>{
			element.style.width = '60%'
			element.parentElement.querySelector('.div-user-2').style.width = '40%'
	})
	element.addEventListener('mouseout',()=>{
		element.style.width = ''
		element.parentElement.querySelector('.div-user-2').style.width = ''
			
	})
				
})
						
document.getElementById('div-voted').addEventListener('click',(event)=>{
		if(event.target.id == 'div-voted'){
			document.getElementById('div-voted').style.display =  'none'
					
		}
			
})
			
//button cancaled
document.getElementById('canceled').addEventListener('click',()=>{           
	document.getElementById('div-voted').style.display =  'none'
			
})
			
//button voted
document.getElementById('voted').addEventListener('click',(event)=>{
		document.getElementById('voted').disabled =  true

		fetch('/playoff/vote',{
			method:'POST',
			headers: {
			    	'Content-Type': 'application/json'
			  	},
				body: JSON.stringify( {
					username:localStorage.getItem('username'),
					password:localStorage.getItem('password'),
					vote: document.querySelector('.div-nick-vote p').innerText.trim().toLowerCase() 
				})
		})
		.then(res => res.text())
		.then(data => {
			console.log(data)
			if(data == "vote counted"){ 
				document.querySelector('.div-response p').innerHTML = 'Voto computado'
				document.querySelector('.div-response p').style.backgroundColor = '#87FB95'	 
				console.log('Voto computado com sucessso')
				
			 } else if (data == "error login") {
				document.querySelector('.div-response p').innerHTML = 'Credenciais invalidas'
				document.querySelector('.div-response p').style.backgroundColor = '#EA493D'	 
				console.error('Erro ao efetuar o voto.\nUsername ou password enviado não corresponde aos valores do banco de dados')
				
			 } else if(data == "you have already voted in this enemy user") {
				document.querySelector('.div-response p').innerHTML = 'Você já votou no adversário'
				document.querySelector('.div-response p').style.backgroundColor = '#FAF2AD'	 
				console.log('Voto invalidado por esgostamento de votos')
				
			 } else if(data == "voting closed"){
				document.querySelector('.div-response p').innerHTML = 'Votação já se encerrou'
				document.querySelector('.div-response p').style.backgroundColor = '#EA493D'	 
				console.error('Erro ao efetuar o voto.\nVotação já se encerrou !')
				location.reload()

			 } else if(data == "erro user null") {
				document.querySelector('.div-response p').innerHTML = 'Erro user null'
				document.querySelector('.div-response p').style.backgroundColor = '#EA493D'	 
				console.error('Erro ao efetuar o voto.\nUsuário não encontrado')
				location.reload()
			 } else {
				document.querySelector('.div-response p').innerHTML = 'Você já votou nesse candidato'
				document.querySelector('.div-response p').style.backgroundColor = '#FAF2AD'	 
				console.log('Voto invalidado por reptição de voto')
			 }
		})
				
		setTimeout(()=>{
				document.getElementById('voted').disabled =  false

		},3000)

})
		




