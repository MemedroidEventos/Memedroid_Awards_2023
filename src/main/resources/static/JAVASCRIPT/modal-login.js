const username = document.getElementById('username')
const password = document.getElementById('password')
const button = document.getElementById('button-login')
const photo = document.getElementById('perfil-photo')
const modal = document.getElementById('modal-login')

modal.addEventListener('click', (event) => {
	if (event.target.id == 'modal-login') {
		document.getElementById('open-modal-login').click()
		document.querySelector('.dialog-box p').innerText = 'Faça seu login abaixo'
		document.querySelector('.dialog-box').style.background = 'ghostwhite'
	}
})

photo.src = `https://appv2.memedroid.com/user_profile/get_user_avatar?username=${localStorage.getItem('username')}&thumb=1`

button.addEventListener('click', () => {

	fetch(`/login/${username.value.trim().toLowerCase()},${password.value.trim().toLowerCase()}`, { method: 'POST' })
		.then(response => response.text())
		.then(text => {

			if (text == "not registered") {
				console.log(text)
				document.querySelector('.dialog-box p').innerText = 'Usuário inexistente'
				document.querySelector('.dialog-box').style.background = '#FB3125'

			} else if (text == "password incorrect") {
				console.log(text)
				button.disabled =  true
				
				document.querySelector('.dialog-box p').innerText = 'Senha incorreta, sepere 3 segundo e tente novamente'
				document.querySelector('.dialog-box').style.background = '#FB3125'
				setTimeout(()=>{
					button.disabled =  false
					document.querySelector('.dialog-box p').innerText = 'Tente novamente'
					document.querySelector('.dialog-box').style.background = 'ghostwhite'
				},3000)

			} else {
				localStorage.setItem('username', username.value.trim().toLowerCase())
				localStorage.setItem('password', password.value.trim().toLowerCase())
				photo.src = `https://appv2.memedroid.com/user_profile/get_user_avatar?username=${localStorage.getItem('username')}&thumb=1`

				document.querySelector('.dialog-box p').innerText = 'Login efetuado com sucesso !'
				document.querySelector('.dialog-box').style.background = '#98F445'
				
				setTimeout(()=>{
					if(document.getElementById('open-modal-login').checked){
						document.getElementById('open-modal-login').click()
					}
				},3500)
			}
		})

})



