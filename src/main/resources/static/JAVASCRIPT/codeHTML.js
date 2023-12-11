export function userHTML(id, nick) {
	return `
    <div class="User" id="${id}">
        <div class="PhotoOfPerfil">
            <img src="https://appv2.memedroid.com/user_profile/get_user_avatar?username=${nick}&thumb=1">
        </div>
        <div class="infromationOfUser">
            <div class="NickName">
                <p>${nick}</p>
            </div>
            <div class="Buttons">
                <button class="VotedPerfil">Votar</button>
                <button class="ViewPerfil" >Ver perfil</button>
            </div>
        </div>

    </div>`
}

export function topUserHTML(nick, img) {
	return `
	<div class="TopUser">
		<div class="TopUser-img">
			<img src="${img}">
		</div>
		<div class="TopUser-text">
			<p>${nick}</p>
		</div>
	</div>
    `
}

export function divDispute(user1 , user2){
	return `
	<div class="div-vote">

		<div class="div-user-1">
			<div class="div-photo">
				<img src="${user1.photo}">
			</div>
			<div class="div-nick">
				<p>${user1.nick}</p>
			</div>
			<div class="div-button">
				<button>Votar</button>
			</div>
		</div>
			
		<div class="div-user-2">
			<div class="div-photo">
				<img src="${user2.photo}">
			</div>
			<div class="div-nick">
				<p>${user2.nick}</p>					
			</div>
			<div class="div-button">
				<button>Votar</button>
			</div>
		</div>
		<div class="red"></div>

	</div>
	`
	
}