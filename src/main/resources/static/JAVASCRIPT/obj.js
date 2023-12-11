export class User {

	constructor(nick, img, id) {
		this.nick = (nick.length > 15 && document.body.clientWidth < 321) ? `${nick.substring(0, 15)}<br>${nick.substring(15, 20)}` : nick
		this.img = img
		this.id = id
		this.html = `
            <div class="User" id="${id}">
                <div class="PhotoOfPerfil">
                    <img src="${img}">
                </div>
                <div class="infromationOfUser">
                    <div class="NickName">
                        <p>${this.nick}</p>
                    </div>
                    <div class="Buttons">
                        <button>Votar</button>
                        <button class="ViewPerfil" >Ver perfil</button>
                    </div>
                </div>

            </div>`

	}

	getHTML() {
		return this.html
	}

}

export class TopUser {

	constructor(nick, img) {
		this.nick = (nick.length < 15 ? nick : nick = nick.substring(0, 15) + "<br>" + nick.substring(15))
		this.img = img

		this.html = `    
        <div class="TopUser">
            <img src="${img}">
            <div>
                <p class="NickNameTopUser">${nick}</p>
            </div>
        </div>
        `

	}
	getHTML() {
		return this.html
	}


}

export const MemedroidUser = [
	"denadaamigo",

]

export const alfabeto = [
	"denadaamigo", "CicloneAlpha", "vitin", "Paumito", "Ttlegend19", "o_mago", "3nzok4", "rakasha11", "Ki-Otario",
	"Atentado_Napalm", "CebolinhaComAids", "Olatote", "Comuna_Crente", "Anarquer", "Ademiro", "Ednaldoagiota",
	"Leonedroid", "Rei_do_vinhedo", "mandiokovski", "Zefa_", "jornaltres", "Toshiba_somaliese", "Amanteigado",
	"Shadow_the_Memehog", "Cafezinhohmmmm", "Neguim.do.RJ", "Nakazaki", "geysonbr", "alexjc2505", "froice_loco",
	"._Priest", "Quixotic", "Koalahh", "Um_inutil", "fingernoodle", "Elieja", "legendarysnake", "Natsuzin",
	"Ummaninho", "Guaravitown", "Major_Azucrim", "yuri_lindoso__5000", "Itakko", "Ibosta", "Rolabosta",
	"Mrmemescomunist", "0_mito_8", "CaralhoOCaraSeMatou", "fernandez065", "Damborowiski", "Wizards",
	"SteveCalvo", "Ablon-Appolyon", "BrunnoCom2N", "ThCruz", "HulkDoZap_HulkAgiota", "Casca", "Passivao",
	"Maderaka_2003", "Otto", "lenni-san-of-memes", "Chaos7", "mppaumos", "BigFatos", "JornalistaFail",
	"seumadruga", "PedroJosefino", "SamusArantesNaciment", "Vitor_Saucer", "azteki", "PHfucku", "Reidostraveco",
	"Redbuly", "Nadro-Jay", "SiegerEvil", "Zeuspcdaxuxa", "Ohloko0", "Yatsura", "Deivid.rd", "Coff", "Chad_Duce",
	"Repa", "VictorWoods", "ArtTheWarrior", "Noxyn1", "_|_", "Mclovin2.0", "R34P3RSS", "PolsefGay", "Vizir",
	"zuero300", "sawako_mizore", "Zyyz", "RichardTheTroll", "RogerDrago", "lUnileloParaverSo", "Jamelao-Quero-Mais",
	"GIGAN", "BrunoChieppe", "Cheetoshuahua", "b4nb4nb4n", "O_Nacionalista", "anjo230308", "Luuckkaz", "MADRUVA",
	"Gabriedsrc", "Memedroider-789", "Paulo_mana", "GreenSauce", "Pelos_Pubianos", "Alien246", "Rom1234",
	"GuistrikerTR", "Mcliquid980", "GH7PHJPA", "Gabo_k", "Haraci_34", "MisterG", "Zero___One", "Tutubarao",
	"Lighter_The_Rider", "etrigam", "charap2", "jubileu790", "Anarom", "Dnetgamer", "Gh0stW4RR10R", "Scaduche2.0",
	"Bico", "NoslimeSaga", "Maichelo", "Shutuptrash", "Vicsantana", "C_U", "Giovanni339", "JerryPorcariasRec",
	"Shiroblood", "lord_gaben", "Allan_Suoza"
];