import { closeVoted } from './functions.js'

let vote =  ''

document.querySelector('.search').addEventListener('input',(event)=>{
	document.querySelectorAll('.Users .User p').forEach(element=>{
		if(element.innerHTML.trim().toLocaleLowerCase().includes(event.target.value.trim().toLocaleLowerCase())){
			element.closest('.User').style.display = 'flex'
		} else {
			element.closest('.User').style.display = 'none'
		}
		
	})
	
})

document.querySelectorAll('.VotedPerfil').forEach(element =>{
	element.addEventListener('click',()=>{
		vote = element.getAttribute('data-username')
		document.getElementById('div-voted').style.display = 'flex'
		document.querySelector('.div-nick-vote p').innerHTML = element.getAttribute('data-username')
		document.querySelector('.div-img-perfil img').src = `https://appv2.memedroid.com/user_profile/get_user_avatar?username=${element.getAttribute('data-username')}&thumb=1`
		document.querySelector('.div-response p').innerHTML = ''
		document.querySelector('.div-response p').style.backgroundColor = 'transparent'

	})
})

//button cancaled vote 
document.getElementById('canceled').addEventListener('click',()=>{
		document.getElementById('div-voted').style.display = 'none'

})

//outside of div
 document.getElementById('div-voted').addEventListener('click',(event)=>{
	 	if(event.target.id == 'div-voted'){
			document.getElementById('div-voted').style.display = 'none' 
		 }
})

//button voting 
document.getElementById('voted').addEventListener('click',()=>{
	
	document.getElementById('voted').disabled =  true
	if(vote != '' && localStorage.getItem('username') && localStorage.getItem('username')){
		fetch('/vote',{
		method:'POST',
		headers: {
    		'Content-Type': 'application/json'
    	},
    	body: JSON.stringify({
              username: localStorage.getItem('username'),
              password: localStorage.getItem('password'),
              vote: vote
         })})
         .then(res => res.text())
         .then(data =>{
			 if(data == "vote counted"){ 
				document.querySelector('.div-response p').innerHTML = 'Voto computado'
				document.querySelector('.div-response p').style.backgroundColor = '#87FB95'	 
				console.log('Voto computado com sucessso')
				
			 } else if (data == "error login") {
				document.querySelector('.div-response p').innerHTML = 'Credenciais invalidas'
				document.querySelector('.div-response p').style.backgroundColor = '#EA493D'	 
				console.error('Erro ao efetuar o voto.\nUsername ou password enviado não corresponde aos valores do banco de dados')
				
			 } else if(data == "votes sold out") {
				document.querySelector('.div-response p').innerHTML = 'Você esgotou seus votos'
				document.querySelector('.div-response p').style.backgroundColor = '#FAF2AD'	 
				console.log('Voto invalidado por esgostamento de votos')
				
			 } else if("voting closed") {
				location.reload() 
			 } else {
				document.querySelector('.div-response p').innerHTML = 'Você já votou nesse candidato'
				document.querySelector('.div-response p').style.backgroundColor = '#FAF2AD'	 
				console.log('Voto invalidado por reptição de voto')
			 }
		 })	
		 console.log(`Voto enviado\nVontante: ${localStorage.getItem('username')}\nVotado: ${vote}\n`)

	} else {
		document.querySelector('.div-response p').innerHTML = 'Você não está logado'
		document.querySelector('.div-response p').style.backgroundColor = '#EA493D'	 
		console.error('Erro ao efetuar o voto.\nLogin ainda não foi efetuado ')

	}
    setTimeout(()=>{
		document.getElementById('voted').disabled =  false

	},3000)
      	
})





