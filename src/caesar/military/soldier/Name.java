package caesar.military.soldier;

import caesar.game.Game;
import org.jetbrains.annotations.NotNull;

public class Name {
	
	private static String[] praenominas = new String[] {
		"Appius",
		"Aulus",
		"Caelus",
		"Decius",
		"Decimus",
		"Faustus",
		"Flavius",
		"Gaius",
		"Gnaeus",
		"Kaeso",
		"Lucius",
		"Mamercus",
		"Manius",
		"Marcus",
		"Mettius",
		"Numerius",
		"Octavius",
		"Publius",
		"Quintus",
		"Secundus",
		"Septimus",
		"Servius",
		"Sextus",
		"Spurius",
		"Tertius",
		"Tiberius",
		"Titus",
		"Agrippa",
		"Amulius",
		"Arruns",
		"Camillus",
		"Canus",
		"Cossus",
		"Drusus",
		"Gallus",
		"Herius",
		"Hostus",
		"Lar",
		"Marcellus",
		"Nero",
		"Nonus",
		"Opiter",
		"Oppius",
		"Paulus",
		"Postumus",
		"Potitus",
		"Primus",
		"Proculus",
		"Silvanus",
		"Sisenna",
		"Tullus",
		"Vel",
		"Vibius",
		"Vopiscus"
	};
	
	private static String[] nominas = new String[] {
		"Abronius",
		"Abudius",
		"Aburius",
		"Accius",
		"Accoleius",
		"Acerronius",
		"Acilius",
		"Aconius",
		"Actorius",
		"Acutius",
		"Aebutius",
		"Aedinius",
		"Aelius",
		"Aemilius",
		"Afinius",
		"Afranius",
		"Agorius",
		"Albanius",
		"Albatius",
		"Albinius",
		"Albius",
		"Albucius",
		"Alfenus",
		"Alfius",
		"Alienus",
		"Allectius",
		"Amafinius",
		"Amatius",
		"Ambrosius",
		"Ampius",
		"Ampudius",
		"Ancharius",
		"Anicius",
		"Annaeus",
		"Anneius",
		"Annius",
		"Anquirinnius",
		"Antistius",
		"Antius",
		"Antonius",
		"Apisius",
		"Aponius",
		"Appius",
		"Appuleius",
		"Apronius",
		"Apustius",
		"Aquillius",
		"Aquinius",
		"Arellius",
		"Arennius",
		"Arminius",
		"Arpineius",
		"Arrecinus",
		"Arrius",
		"Arruntius",
		"Arsinius",
		"Articuleius",
		"Artorius",
		"Asconius",
		"Asellius",
		"Asinius",
		"Ateius",
		"Aternius",
		"Atius",
		"Atilius",
		"Atinius",
		"Atrius",
		"Attius",
		"Audasius",
		"Aufeius",
		"Aufidius",
		"Aulius",
		"Aurelius",
		"Aurius",
		"Aurunculeius",
		"Ausonius",
		"Autronius",
		"Avianus",
		"Avidius",
		"Avienus",
		"Avilius",
		"Avius",
		"Axius",
		"Babrius",
		"Baebius",
		"Balventius",
		"Bantius",
		"Barbatius",
		"Barrius",
		"Bavius",
		"Bellicius",
		"Bellienus",
		"Bellius",
		"Betilienus",
		"Betitius",
		"Betucius",
		"Betuus",
		"Blandius",
		"Blossius",
		"Boionius",
		"Bruttius",
		"Bucculeius",
		"Burbuleius",
		"Burrienus",
		"Caecilius",
		"Caecina",
		"Caecius",
		"Caedicius",
		"Caelius",
		"Caeparius",
		"Caepasius",
		"Caerellius",
		"Caesellius",
		"Caesennius",
		"Caesetius",
		"Caesius",
		"Caesonius",
		"Caesulenus",
		"Caetronius",
		"Calavius",
		"Calesterna",
		"Calidius",
		"Calpurnius",
		"Calventius",
		"Calvisius",
		"Campatius",
		"Canidius",
		"Caninius",
		"Canius",
		"Cantilius",
		"Cantius",
		"Canuleius",
		"Canutius",
		"Carfulenus",
		"Carisius",
		"Caristanius",
		"Carius",
		"Carpinatius",
		"Carrinas",
		"Carteius",
		"Carvilius",
		"Casperius",
		"Cassius",
		"Castricius",
		"Castrinius",
		"Catienus",
		"Catilius",
		"Catius",
		"Ceionius",
		"Centenius",
		"Ceppuleius",
		"Cestius",
		"Cicereius",
		"Cilnius",
		"Cincius",
		"Cispius",
		"Classidius",
		"Claudius",
		"Cloelius",
		"Cluentius",
		"Cluilius",
		"Clutorius",
		"Cluvius",
		"Cocceius",
		"Coelius",
		"Cominius",
		"Condetius",
		"Consentius",
		"Considius",
		"Consius",
		"Coponius",
		"Cordius",
		"Corfidius",
		"Cornelius",
		"Cornificius",
		"Coruncanius",
		"Cosconius",
		"Cossinius",
		"Cossutius",
		"Cotius",
		"Cottius",
		"Crassitius",
		"Crepereius",
		"Critonius",
		"Cupiennius",
		"Curiatius",
		"Curius",
		"Curtilius",
		"Curtius",
		"Cusinius",
		"Cuspius",
		"Decentius",
		"Decidius",
		"Decimius",
		"Decius",
		"Dellius",
		"Desticius",
		"Dexsius",
		"Didius",
		"Digitius",
		"Dillius",
		"Domitius",
		"Dubius",
		"Duccius",
		"Duilius",
		"Durmius",
		"Duronius",
		"Eggius",
		"Egilius",
		"Egnatius",
		"Egnatuleius",
		"Egrilius",
		"Elvius",
		"Ennius",
		"Epidius",
		"Eppius",
		"Equitius",
		"Erucius",
		"Expentanius",
		"Fabius",
		"Fabricius",
		"Fadius",
		"Faenius",
		"Falcidius",
		"Falerius",
		"Faminius",
		"Fannius",
		"Farsuleius",
		"Faucius",
		"Favonius",
		"Festinius",
		"Fidiculanius",
		"Firmius",
		"Flaminius",
		"Flavinius",
		"Flavius",
		"Flavonius",
		"Floridius",
		"Florius",
		"Floronius",
		"Fonteius",
		"Foslius",
		"Fufetius",
		"Fuficius",
		"Fufidius",
		"Fufius",
		"Fulcinius",
		"Fulginas",
		"Fulvius",
		"Fundanius",
		"Furius",
		"Furnius",
		"Gabinius",
		"Galerius",
		"Gallius",
		"Gargonius",
		"Gavius",
		"Geganius",
		"Gellius",
		"Geminius",
		"Genucius",
		"Gessius",
		"Glicius",
		"Granius",
		"Gratidius",
		"Gratius",
		"Haterius",
		"Heius",
		"Helvidius",
		"Helvius",
		"Herennius",
		"Herennuleius",
		"Herminius",
		"Hirrius",
		"Hirtius",
		"Hirtuleius",
		"Horatius",
		"Hordeonius",
		"Hortensius",
		"Hosidius",
		"Hostilius",
		"Hostius",
		"Iccius",
		"Icilius",
		"Insteius",
		"Jallius",
		"Julius",
		"Junius",
		"Juventius",
		"Laberius",
		"Labienus",
		"Lacerius",
		"Laecanius",
		"Laelius",
		"Laenius",
		"Laetilius",
		"Laetorius",
		"Lafrenius",
		"Lamponius",
		"Laronius",
		"Lartius",
		"Latinius",
		"Lavinius",
		"Lemonius",
		"Lentidius",
		"Lepidius",
		"Libertius",
		"Liburnius",
		"Licinius",
		"Ligarius",
		"Livinius",
		"Livius",
		"Lollius",
		"Longinius",
		"Loreius",
		"Lucceius",
		"Lucienus",
		"Lucilius",
		"Lucius",
		"Lucretius",
		"Lurius",
		"Luscius",
		"Lusius",
		"Lutatius",
		"Macrinius",
		"Maecenas",
		"Maecilius",
		"Maecius",
		"Maelius",
		"Maenas",
		"Maenius",
		"Maevius",
		"Magius",
		"Mallius",
		"Mamercius",
		"Mamilius",
		"Manilius",
		"Manlius",
		"Marcius",
		"Marius",
		"Martinius",
		"Matienus",
		"Matinius",
		"Matius",
		"Matrinius",
		"Maximius",
		"Memmius",
		"Menenius",
		"Menius",
		"Mescinius",
		"Messienus",
		"Messius",
		"Mestrius",
		"Metilius",
		"Mettius",
		"Milonius",
		"Mimesius",
		"Minatius",
		"Minicius",
		"Minidius",
		"Minius",
		"Minucius",
		"Modius",
		"Mucius",
		"Mummius",
		"Munatius",
		"Munius",
		"Murrius",
		"Mussidius",
		"Mustius",
		"Mutius",
		"Naevius",
		"Nasennius",
		"Nasidienus",
		"Nasidius",
		"Nautius",
		"Neratius",
		"Nerfinius",
		"Nerius",
		"Nigidius",
		"Ninnius",
		"Nipius",
		"Nonius",
		"Norbanus",
		"Novellius",
		"Novius",
		"Numerius",
		"Numicius",
		"Numisius",
		"Numitorius",
		"Nummius",
		"Numonius",
		"Nymphidius",
		"Obellius",
		"Obultronius",
		"Occius",
		"Oclatinius",
		"Oclatius",
		"Octavenus",
		"Octavius",
		"Ofanius",
		"Ofilius",
		"Ogulnius",
		"Ollius",
		"Opellius",
		"Opetreius",
		"Opimius",
		"Opisius",
		"Opiternius",
		"Oppidius",
		"Oppius",
		"Opsidius",
		"Opsilius",
		"Opsius",
		"Oranius",
		"Orbicius",
		"Orbilius",
		"Orchius",
		"Orcivius",
		"Orfidius",
		"Orfius",
		"Orosius",
		"Oscius",
		"Ostorius",
		"Otacilius",
		"Ovidius",
		"Ovinius",
		"Paccius",
		"Pacidius",
		"Pacilius",
		"Paconius",
		"Pactumeius",
		"Pacuvius",
		"Palfurius",
		"Palpellius",
		"Pantuleius",
		"Papinius",
		"Papirius",
		"Papius",
		"Pasidienus",
		"Pasidius",
		"Passienus",
		"Patrobius",
		"Patulcius",
		"Pedanius",
		"Pedius",
		"Peducaeus",
		"Peltrasius",
		"Percennius",
		"Perperna",
		"Persius",
		"Pescennius",
		"Petillius",
		"Petreius",
		"Petronius",
		"Petrosidius",
		"Pilius",
		"Pinarius",
		"Pinnius",
		"Pisentius",
		"Placidius",
		"Plaetorius",
		"Plaguleius",
		"Plancius",
		"Plarius",
		"Plautius",
		"Pleminius",
		"Plinius",
		"Poetelius",
		"Pollius",
		"Pompeius",
		"Pompilius",
		"Pomponius",
		"Pomptinus",
		"Pontidius",
		"Pontificius",
		"Pontilienus",
		"Pontilius",
		"Pontius",
		"Popaedius",
		"Popidius",
		"Poppaeus",
		"Porcius",
		"Postumius",
		"Postumulenus",
		"Potitius",
		"Praecilius",
		"Praeconius",
		"Precius",
		"Priscius",
		"Procilius",
		"Proculeius",
		"Propertius",
		"Proxinius",
		"Publicius",
		"Publilius",
		"Pupius",
		"Quartinius",
		"Quartius",
		"Quinctilius",
		"Quinctius",
		"Quirinius",
		"Rabirius",
		"Rabonius",
		"Rabuleius",
		"Racilius",
		"Raecius",
		"Ragonius",
		"Rammius",
		"Ranius",
		"Rasinius",
		"Reginius",
		"Remmius",
		"Rennius",
		"Resius",
		"Romanius",
		"Romilius",
		"Romogillius",
		"Roscius",
		"Rubellius",
		"Rubrenus",
		"Rubrius",
		"Rufinius",
		"Rufius",
		"Rufrius",
		"Rullius",
		"Rupilius",
		"Rusonius",
		"Rusticelius",
		"Rustius",
		"Rutilius",
		"Sabellius",
		"Sabidius",
		"Sabinius",
		"Sabucius",
		"Saenius",
		"Safinius",
		"Salienus",
		"Sallustius",
		"Salonius",
		"Saltius",
		"Saltorius",
		"Salvidienus",
		"Salvidius",
		"Salvius",
		"Salvienus",
		"Sammius",
		"Sanquinius",
		"Sariolenus",
		"Sarius",
		"Satellius",
		"Satrienus",
		"Satrius",
		"Sattius",
		"Saturius",
		"Saufeius",
		"Scaevilius",
		"Scaevinius",
		"Scaevius",
		"Scandilius",
		"Scantinius",
		"Scantius",
		"Scaptius",
		"Scoedius",
		"Scuilius",
		"Scutarius",
		"Scribonius",
		"Seccius",
		"Secundinius",
		"Secundius",
		"Sedatius",
		"Segulius",
		"Seius",
		"Selicius",
		"Sellius",
		"Sempronius",
		"Sennius",
		"Sentius",
		"Seppius",
		"Septicius",
		"Septimius",
		"Septimuleius",
		"Septueius",
		"Sepullius",
		"Sepunius",
		"Sergius",
		"Serius",
		"Sertorius",
		"Servaeus",
		"Servenius",
		"Servilius",
		"Servius",
		"Sestius",
		"Severius",
		"Sextilius",
		"Sextius",
		"Sibidienus",
		"Sicinius",
		"Sidonius",
		"Silicius",
		"Silius",
		"Silvius",
		"Sinicius",
		"Sinuleius",
		"Sisenna",
		"Sittius",
		"Socellius",
		"Sollius",
		"Sornatius",
		"Sosius",
		"Sotidius",
		"Spurinna",
		"Spurius",
		"Staius",
		"Statilius",
		"Statius",
		"Stertinius",
		"Suedius",
		"Suetonius",
		"Suilius",
		"Sulpicius",
		"Tadius",
		"Tanicius",
		"Tanusius",
		"Tapsenna",
		"Tarpeius",
		"Tarquinius",
		"Tarquitius",
		"Terentilius",
		"Terentius",
		"Tertinius",
		"Tettidius",
		"Tettiedius",
		"Tettienus",
		"Tettius",
		"Thorius",
		"Tigellius",
		"Tineius",
		"Titanius",
		"Titinius",
		"Titius",
		"Titurius",
		"Tonantius",
		"Trebatius",
		"Trebellius",
		"Trebius",
		"Treblanus",
		"Trebonius",
		"Tremellius",
		"Tuccius",
		"Tullius",
		"Turallasius",
		"Turius",
		"Turpilius",
		"Turullius",
		"Ulpius",
		"Umbrius",
		"Ummidius",
		"Urgulanius",
		"Urseius",
		"Valerius",
		"Varenus",
		"Varinius",
		"Varisidius",
		"Varius",
		"Vatinius",
		"Vecilius",
		"Vedius",
		"Velius",
		"Velleius",
		"Ventidius",
		"Vequasius",
		"Veranius",
		"Verecundius",
		"Vergilius",
		"Verginius",
		"Verres",
		"Verrius",
		"Vesnius",
		"Vesonius",
		"Vestorius",
		"Vestricius",
		"Vettius",
		"Veturius",
		"Vibenius",
		"Vibidius",
		"Vibius",
		"Vicirius",
		"Victorinius",
		"Victorius",
		"Victricius",
		"Viducius",
		"Vigilius",
		"Villius",
		"Vinicius",
		"Vinius",
		"Vipsanius",
		"Vipstanus",
		"Viridius",
		"Virius",
		"Visellius",
		"Vistilius",
		"Vitellius",
		"Vitrasius",
		"Vitruvius",
		"Voconius",
		"Volcacius",
		"Volumnius",
		"Volusenna",
		"Volusenus",
		"Volusius",
		"Vorenius",
		"Vulius"
	};
	
	private static String[] gaulNames = new String[] {
		"Segomaros",
		"Adcanaunos",
		"Carantillo",
		"Caritosus",
		"Catamanus",
		"Iantumalius",
		"Mertoualus",
		"Congenno",
		"Vallus",
		"Trogimarus",
		"Atgite",
		"Dattovir",
		"Onalisus",
		"Annamus",
		"Samio",
		"Comatullus",
		"Cinto",
		"Vecto",
		"Alebece",
		"Sammo",
		"Agisillus",
		"Curcagnus",
		"Billicedo",
		"Smertulitanus",
		"Cattabbot",
		"Tanco",
		"Iotobito",
		"Caurus",
		"Miletumarus",
		"Taurou",
		"Caccuso",
		"Catavignus",
		"Genetlus",
		"Vocarantus",
		"Venicarus",
		"Banu",
		"Cunegni",
		"Busturo",
		"Epomedius",
		"Epacus",
		"Sanicios",
		"Vecto",
		"Cricirus",
		"Sancotalus",
		"Ceno",
		"Ulcagni",
		"Carantillo",
		"Ambillus",
		"Atesios",
		"Caturo",
		"Cricirus",
		"Haesus",
		"Regenus",
		"Cobledulitauus",
		"Atesios",
		"Alpus",
		"Boudillus",
		"Rovicus",
		"Caritosus",
		"Donnadu",
		"Genillus",
		"Conteddius",
		"Balaesus",
		"Cottalus",
		"Cotillus",
		"Criciro",
		"Venecarus",
		"Andosion",
		"Condarillus",
		"Cenocantus",
		"Maglagni",
		"Vopiscus",
		"Eburianus",
		"Epotsorouidus",
		"Caraddounius",
		"Toutobocio",
		"Congonnetiacus",
		"Vlatcani",
		"Regininus",
		"Viranus",
		"Tasgilia",
		"Betudaca",
		"Loucitta",
		"Nertomaria",
		"Vrittia",
		"Venaesia",
		"Vebrumma",
		"Virodu",
		"Cotina",
		"Corobilla",
		"Nammota",
		"Aleasiumara",
		"Nemetocena",
		"Comiomara",
		"Larma",
		"Ibliomaria",
		"Eliomara",
		"Mattosa",
		"Vicana",
		"Namuta",
		"Gnatusius",
		"Dalagni",
		"Litavis",
		"Virocantus",
		"Vlatucni",
		"Banni",
		"Andosteni",
		"Sacrovirus",
		"Tanco",
		"Vridolanos",
		"Diddignatus",
		"Cabriabantos",
		"Talutius",
		"Cintio",
		"Samocenus",
		"Macareus",
		"Viriaicus",
		"Acedilu",
		"Carino",
		"Adretilis"
	};
	
	@NotNull
	public static String getRandomRoman() {
		return praenominas[Game.getRandomInt(praenominas.length)] + " " +
			nominas[Game.getRandomInt(nominas.length)];
	}
	
	@NotNull
	public static String getRandomGallic() {
		return gaulNames[Game.getRandomInt(gaulNames.length)];
	}
}