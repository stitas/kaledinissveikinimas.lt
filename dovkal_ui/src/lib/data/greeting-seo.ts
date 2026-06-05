// src/lib/data/seo-pages.ts

export type GreetingSeoPage = {
	slug: string;
	forWhom: string;
	withWhat: string;
	who: string;

	title: string;
	description: string;

	heroIntro: string;
	heroSecondParagraph: string;

	giftTitle: string;
	giftParagraphOne: string;
	giftParagraphTwo: string;

	personalTitle: string;
	personalParagraphOne: string;
	personalParagraphTwo: string;
	personalParagraphThree: string;

	processParagraph: string;

	shareTitle: string;
	shareParagraphOne: string;
	shareParagraphTwo: string;
	shareParagraphThree: string;

	exampleGreeting: string;

	secondImage: string;
	secondImageAlt: string;

	fourthImage: string;
	fourthImageAlt: string;
};

export const seoPages: GreetingSeoPage[] = [
	{
		slug: 'kaledinis-sveikinimas-vaikams',
		forWhom: 'vaikams',
		withWhat: 'vaikams skirtu',
		who: 'vaikas',
		title: 'Kalėdinis sveikinimas vaikams',
		description: 'Kalėdinis sveikinimas vaikams. Sukurkite personalizuotą Kalėdų Senelio video sveikinimą vaikui vos per kelias minutes nuo 6,99 €.',
		heroIntro: 'Personalizuotas Kalėdų Senelio video sveikinimas vaikams. Įrašykite savo tekstą, pasirinkite video šabloną ir gaukite vaikui skirtą šventinį sveikinimą vos per kelias minutes.',
		heroSecondParagraph: 'Tai paprasta ir jauki kalėdinė dovana vaikams, kurią galima peržiūrėti telefone, planšetėje ar kompiuteryje. Registracija nereikalinga, o sveikinimą galima atsisiųsti ir pasidalinti su šeima.',
		giftTitle: 'Puiki kalėdinė dovana vaikams',
		giftParagraphOne: 'Kalėdinis video sveikinimas vaikams sukuria daugiau įspūdžio nei paprasta žinutė ar atvirukas. Vaikas pamato Kalėdų Senelį ir išgirsta jam skirtą sveikinimą, todėl dovana atrodo asmeniška ir stebuklinga.',
		giftParagraphTwo: 'Toks sveikinimas tinka vaikui, sūnui, dukrai, anūkui, anūkei ar krikšto vaikui. Jį galima parodyti Kalėdų rytą arba prieš šventes.',
		personalTitle: 'Asmeniškas Kalėdų Senelio sveikinimas vaikui',
		personalParagraphOne: 'Vaikams labiausiai patinka sveikinimai, kuriuose jie atpažįsta save. Į tekstą galite įtraukti vaiko vardą, gerą elgesį, pasiekimus, pomėgius ar palinkėjimą ateinantiems metams.',
		personalParagraphTwo: 'Tekstą galite parašyti patys arba pradėti nuo paruošto šablono ir jį pritaikyti savo vaikui.',
		personalParagraphThree: 'Jums nereikia filmuoti, montuoti ar įrašinėti balso. Užtenka parašyti sveikinimo tekstą, o video bus sugeneruotas automatiškai po apmokėjimo.',
		processParagraph: 'Kalėdinį video sveikinimą vaikams galite sukurti tiesiai naršyklėje. Ir tai padaryti galite vos per 3 žingsnius.',
		shareTitle: 'Patogu peržiūrėti, atsisiųsti ir parodyti vaikui',
		shareParagraphOne: 'Kai video sveikinimas paruošiamas, gaunate individualią nuorodą. Per ją galite peržiūrėti Kalėdų Senelio sveikinimą vaikui ir atsisiųsti video į savo įrenginį.',
		shareParagraphTwo: 'Su vaikams skirtu sveikinimu patogu pasidalinti žinute, el. paštu ar šeimos pokalbyje. Tai ypač naudinga, jei vaikas gyvena kitame mieste arba norite nustebinti jį nuotoliniu būdu.',
		shareParagraphThree: 'Video galima išsaugoti ir peržiūrėti dar kartą vėliau. Tai paprasta, greita ir asmeniška kalėdinė dovana vaikams, kuri palieka gražų šventinį prisiminimą.',
		exampleGreeting: 'Ho ho ho! Sveikas, Rokai! Čia Kalėdų Senelis. Visus metus stebėjau tavo elgėsį ir turiu pasakyti, kad didžiuojuosi tavimi. Šiais metais buvai labai geras vaikas, todėl turiu tau gerų žinių. Tavo vardą jau užsirašiau į ypatingų dovanų sąrašą. Nepamiršk ir toliau klausyti mamos bei tėčio, būti mandagus, draugiškas ir padėti kitiems, kad kitais metais vėl atsidurtum mano sąraše. Linkiu tau daug džiaugsmo, skanių saldainių, o svarbiausia linksmų ir stebuklingų kalėdų. Iki Kalėdų, Rokai!',
		secondImage: '/images/dovana/vaikas-ziuri-kaledu-senelio-sveikinima.webp',
		secondImageAlt: "Vaikas žiūri Kalėdų Senelio video sveikinimą telefone prie Kalėdų eglutės",
		fourthImage: '/images/dovana/draugai-ziuri-kaledini-sveikinima.webp',
		fourthImageAlt: 'aa',
	},
	{
		slug: 'kaledinis-sveikinimas-draugams',
		forWhom: 'draugams',
		withWhat: 'draugams skirtu',
		who: 'draugas',
		title: 'Kalėdinis sveikinimas draugams',
		description: 'Kalėdinis sveikinimas draugams. Sukurkite linksmą Kalėdų Senelio video sveikinimą draugui ar draugei vos per kelias minutes nuo 6,99 €.',
		heroIntro: 'Personalizuotas Kalėdų Senelio video sveikinimas draugams. Įrašykite savo tekstą, pasirinkite video šabloną ir gaukite draugams skirtą šventinį sveikinimą vos per kelias minutes.',
		heroSecondParagraph: 'Tai linksma ir paprasta kalėdinė dovana draugams, kurią galima peržiūrėti telefone, planšetėje ar kompiuteryje. Registracija nereikalinga, o sveikinimą galima atsisiųsti ir pasidalinti žinute.',
		giftTitle: 'Puiki kalėdinė dovana draugams',
		giftParagraphOne: 'Kalėdinis video sveikinimas draugams yra geras pasirinkimas, kai norite nustebinti artimą žmogų kitaip nei įprasta. Draugas pamato Kalėdų Senelį ir išgirsta jam skirtą sveikinimą, todėl dovana atrodo linksma ir asmeniška.',
		giftParagraphTwo: 'Toks sveikinimas tinka geriausiam draugui, draugei, draugų grupei ar žmogui, kurį norite pralinksminti per šventes. Jį galima nusiųsti prieš Kalėdas, Kalėdų rytą arba tada, kai norite sukurti gerą nuotaiką.',
		personalTitle: 'Asmeniškas Kalėdų Senelio sveikinimas draugui',
		personalParagraphOne: 'Draugams dažnai labiausiai patinka sveikinimai su asmeninėmis detalėmis. Į tekstą galite įtraukti draugo vardą, bendrą juokelį, prisiminimą, metų įvykį ar linksmą palinkėjimą.',
		personalParagraphTwo: 'Kalėdų Senelio video sveikinimas draugui gali būti šiltas, juokingas arba lengvai pašėlęs. Tekstą galite parašyti patys arba pradėti nuo paruošto šablono ir jį pritaikyti savo draugui.',
		personalParagraphThree: 'Jums nereikia filmuoti, montuoti ar įrašinėti balso. Užtenka parašyti sveikinimo tekstą, o video bus sugeneruotas automatiškai po apmokėjimo.',
		processParagraph: 'Kalėdinį video sveikinimą draugams galite sukurti tiesiai naršyklėje. Ir tai padaryti galite vos per 3 žingsnius.',
		shareTitle: 'Patogu peržiūrėti, atsisiųsti ir nusiųsti draugui',
		shareParagraphOne: 'Kai video sveikinimas paruošiamas, gaunate individualią nuorodą. Per ją galite peržiūrėti Kalėdų Senelio sveikinimą draugui ir atsisiųsti video į savo įrenginį.',
		shareParagraphTwo: 'Su draugams skirtu sveikinimu patogu pasidalinti žinute, el. paštu ar socialiniuose tinkluose. Tai ypač naudinga, jei draugas gyvena kitame mieste arba negalite susitikti per šventes.',
		shareParagraphThree: 'Video galima išsaugoti ir peržiūrėti dar kartą vėliau. Tai paprasta, greita ir asmeniška kalėdinė dovana draugams, kuri sukuria šventinę nuotaiką.',
		exampleGreeting: 'Ho ho ho! Sveikas, Tomai! Čia Kalėdų Senelis. Girdėjau, kad šiais metais buvai tikras nuotykių žmogus ir nepraradai geros nuotaikos. Tavo draugai sakė, kad su tavimi niekada nebūna nuobodu, todėl siunčiu tau didelį kalėdinį sveikinimą. Linkiu daug juoko, gerų akimirkų, skanių vaišių ir dar daugiau smagių istorijų kitais metais. Linksmų Kalėdų, Tomai!',
		secondImage: '/images/dovana/draugai-ziuri-kaledini-sveikinima.webp',
		secondImageAlt: "Draugai kartu žiūri kalėdinį video sveikinimą telefone jaukioje šventinėje aplinkoje",
		fourthImage: '/images/dovana/kolegos-ziuri-kaledini-sveikinima-ofise.webp',
		fourthImageAlt: 'Kolegos biure žiūri Kalėdų Senelio video sveikinimą per telefoną',
	},
	{
		slug: 'kaledinis-sveikinimas-kolegoms',
		forWhom: 'kolegoms',
		withWhat: 'kolegoms skirtu',
		who: 'kolega',
		title: 'Kalėdinis sveikinimas kolegoms',
		description: 'Kalėdinis sveikinimas kolegoms. Sukurkite personalizuotą Kalėdų Senelio video sveikinimą kolegai ar komandai vos per kelias minutes nuo 6,99 €.',
		heroIntro: 'Personalizuotas Kalėdų Senelio video sveikinimas kolegoms. Įrašykite savo tekstą, pasirinkite video šabloną ir gaukite kolegoms skirtą šventinį sveikinimą vos per kelias minutes.',
		heroSecondParagraph: 'Tai paprasta ir smagi kalėdinė dovana kolegoms ar visai komandai. Registracija nereikalinga, o paruoštą video galima atsisiųsti ir pasidalinti el. paštu, žinute ar komandos pokalbyje.',
		giftTitle: 'Puiki kalėdinė dovana kolegoms',
		giftParagraphOne: 'Kalėdinis video sveikinimas kolegoms yra geras būdas padėkoti už bendrą darbą, gerą nuotaiką ir kartu įveiktus metų iššūkius. Kalėdų Senelio sveikinimas atrodo asmeniškiau, bei linksmiau nei paprastas el. laiškas ar standartinė žinutė.',
		giftParagraphTwo: 'Toks sveikinimas tinka kolegai, vadovui, komandai ar visam skyriui. Jį galima parodyti per šventinį susitikimą, nusiųsti prieš Kalėdas arba panaudoti kaip lengvą metų pabaigos staigmeną.',
		personalTitle: 'Asmeniškas Kalėdų Senelio sveikinimas kolegai',
		personalParagraphOne: 'Kolegoms skirtame sveikinime galite paminėti vardą, komandą, bendrą projektą, metų pasiekimą ar linksmą darbo akimirką. Tokios detalės padeda sveikinimui skambėti gyviau ir nuoširdžiau.',
		personalParagraphTwo: 'Kalėdų Senelio video sveikinimas kolegai gali būti šiltas, profesionalus arba lengvai juokingas. Tekstą galite parašyti patys arba pradėti nuo paruošto šablono ir jį pritaikyti savo komandai.',
		personalParagraphThree: 'Jums nereikia filmuoti, montuoti ar įrašinėti balso. Užtenka parašyti sveikinimo tekstą, o video bus sugeneruotas automatiškai po apmokėjimo.',
		processParagraph: 'Kalėdinį video sveikinimą kolegoms galite sukurti tiesiai naršyklėje. Ir tai padaryti galite vos per 3 žingsnius.',
		shareTitle: 'Patogu peržiūrėti, atsisiųsti ir pasidalinti su komanda',
		shareParagraphOne: 'Kai video sveikinimas paruošiamas, gaunate individualią nuorodą. Per ją galite peržiūrėti Kalėdų Senelio sveikinimą kolegoms ir atsisiųsti video į savo įrenginį.',
		shareParagraphTwo: 'Su kolegoms skirtu sveikinimu patogu pasidalinti el. paštu, žinute ar vidiniame komandos pokalbyje. Tai ypač naudinga, jei dalis komandos dirba nuotoliu arba negali dalyvauti bendrame šventiniame susitikime.',
		shareParagraphThree: 'Video galima išsaugoti ir peržiūrėti dar kartą vėliau. Tai paprasta, greita ir asmeniška kalėdinė dovana kolegoms, kuri padeda sukurti šventinę nuotaiką darbe.',
		exampleGreeting: 'Ho ho ho! Sveiki, kolegos! Čia Kalėdų Senelis. Girdėjau, kad šiais metais daug dirbote, sprendėte sudėtingas užduotis ir vis tiek nepraradote geros nuotaikos. Noriu palinkėti jums ramių švenčių, gero poilsio, skanių vaišių ir dar daugiau sėkmingų darbų kitais metais. Ačiū už jūsų pastangas ir linksmų Kalėdų visai komandai!',
		secondImage: '/images/dovana/kolegos-ziuri-kaledini-sveikinima-ofise.webp',
		secondImageAlt: "Kolegos biure žiūri Kalėdų Senelio video sveikinimą per telefoną",
		fourthImage: '/images/dovana/draugai-ziuri-kaledini-sveikinima.webp',
		fourthImageAlt: 'Draugai kartu žiūri kalėdinį video sveikinimą telefone jaukioje šventinėje aplinkoje',
	},
	{
		slug: 'kaledinis-sveikinimas-mamai',
		forWhom: 'mamai',
		withWhat: 'mamai skirtu',
		who: 'mama',
		title: 'Kalėdinis sveikinimas mamai',
		description: 'Kalėdinis sveikinimas mamai. Sukurkite šiltą Kalėdų Senelio video sveikinimą mamai vos per kelias minutes nuo 6,99 €.',
		heroIntro: 'Personalizuotas Kalėdų Senelio video sveikinimas mamai. Įrašykite savo tekstą, pasirinkite video šabloną ir gaukite mamai skirtą šventinį sveikinimą vos per kelias minutes.',
		heroSecondParagraph: 'Tai paprasta ir jauki kalėdinė dovana mamai, kurią galima peržiūrėti telefone, planšetėje ar kompiuteryje. Registracija nereikalinga, o sveikinimą galima atsisiųsti ir pasidalinti su šeima.',
		giftTitle: 'Puiki kalėdinė dovana mamai',
		giftParagraphOne: 'Kalėdinis video sveikinimas mamai yra šiltas būdas padėkoti už rūpestį, meilę ir visus metus buvimą šalia. Toks sveikinimas atrodo asmeniškiau nei paprasta žinutė ar standartinis atvirukas.',
		giftParagraphTwo: 'Toks sveikinimas tinka mamai, kurią norite pradžiuginti Kalėdų rytą, prieš šventes arba tada, kai negalite būti kartu. Video galima nusiųsti nuotoliniu būdu ir sukurti jaukią šventinę akimirką.',
		personalTitle: 'Asmeniškas Kalėdų Senelio sveikinimas mamai',
		personalParagraphOne: 'Mamai skirtame sveikinime galite paminėti jos vardą, padėką už rūpestį, gražius prisiminimus ar šiltą palinkėjimą ateinantiems metams. Tokios detalės sveikinimą padaro nuoširdesnį. Už įprastas sveikinimus ir atvirutes.',
		personalParagraphTwo: 'Kalėdų Senelio video sveikinimas mamai gali būti šiltas, jautrus arba linksmas. Tekstą galite parašyti patys arba pradėti nuo paruošto šablono ir jį pritaikyti savo mamai.',
		personalParagraphThree: 'Jums nereikia filmuoti, montuoti ar įrašinėti balso. Užtenka parašyti sveikinimo tekstą, o video bus sugeneruotas automatiškai po apmokėjimo.',
		processParagraph: 'Kalėdinį video sveikinimą mamai galite sukurti tiesiai naršyklėje. Ir tai padaryti galite vos per 3 žingsnius.',
		shareTitle: 'Patogu peržiūrėti, atsisiųsti ir nusiųsti mamai',
		shareParagraphOne: 'Kai video sveikinimas paruošiamas, gaunate individualią nuorodą. Per ją galite peržiūrėti Kalėdų Senelio sveikinimą mamai ir atsisiųsti video į savo įrenginį.',
		shareParagraphTwo: 'Su mamai skirtu sveikinimu patogu pasidalinti žinute, el. paštu ar šeimos pokalbyje. Tai ypač naudinga, jei mama gyvena kitame mieste arba negalite susitikti per šventes.',
		shareParagraphThree: 'Video galima išsaugoti ir peržiūrėti dar kartą vėliau. Tai paprasta, greita ir asmeniška kalėdinė dovana mamai, kuri palieka gražų šventinį prisiminimą.',
		exampleGreeting: 'Ho ho ho! Labas, mama! Čia Kalėdų Senelis. Girdėjau, kad šiais metais vėl buvai pilna rūpesčio, meilės ir šilumos savo šeimai. Noriu tau padėkoti už viską, ką darai kiekvieną dieną. Linkiu tau ramių Kalėdų, daug šypsenų, jaukių akimirkų ir gražių metų priešakyje. Tegul šios šventės būna pilnos meilės, poilsio ir mažų stebuklų. Linksmų Kalėdų, mama!',
		secondImage: '/images/sveikinimai/sveikinimai_kaledinis-sveikinimas-mamai_mama-ziuri-kaledini-sveikinima-namuose.webp',
		secondImageAlt: "Mama namuose žiūri kalėdinį video sveikinimą telefone prie Kalėdų eglutės",
		fourthImage: '/images/dovana/draugai-ziuri-kaledini-sveikinima.webp',
		fourthImageAlt: 'Draugai kartu žiūri kalėdinį video sveikinimą telefone jaukioje šventinėje aplinkoje',
	},
	{
		slug: 'kaledinis-sveikinimas-tevams',
		forWhom: 'tėvams',
		withWhat: 'tėvams skirtu',
		who: 'tėvai',
		title: 'Kalėdinis sveikinimas tėvams',
		description: 'Kalėdinis sveikinimas tėvams. Sukurkite šiltą Kalėdų Senelio video sveikinimą tėvams vos per kelias minutes nuo 6,99 €.',
		heroIntro: 'Personalizuotas Kalėdų Senelio video sveikinimas tėvams. Įrašykite savo tekstą, pasirinkite video šabloną ir gaukite tėvams skirtą šventinį sveikinimą vos per kelias minutes.',
		heroSecondParagraph: 'Tai paprasta ir jauki kalėdinė dovana tėvams, kurią galima peržiūrėti telefone, planšetėje ar kompiuteryje. Registracija nereikalinga, o sveikinimą galima atsisiųsti ir pasidalinti su šeima.',
		giftTitle: 'Puiki kalėdinė dovana tėvams',
		giftParagraphOne: 'Kalėdinis video sveikinimas tėvams yra šiltas būdas padėkoti už rūpestį, palaikymą ir buvimą šalia. Toks sveikinimas atrodo asmeniškiau nei paprasta žinutė ar standartinis atvirukas.',
		giftParagraphTwo: 'Toks sveikinimas tinka mamai ir tėčiui, kuriuos norite pradžiuginti Kalėdų rytą, prieš šventes arba tada, kai negalite būti kartu. Video galima nusiųsti nuotoliniu būdu ir sukurti jaukią šventinę akimirką.',
		personalTitle: 'Asmeniškas Kalėdų Senelio sveikinimas tėvams',
		personalParagraphOne: 'Tėvams skirtame sveikinime galite paminėti jų vardus, padėką už meilę, gražius šeimos prisiminimus ar šiltą palinkėjimą ateinantiems metams. Tokios detalės sveikinimą padaro nuoširdesnį.',
		personalParagraphTwo: 'Kalėdų Senelio video sveikinimas tėvams gali būti šiltas, jautrus arba linksmas. Tekstą galite parašyti patys arba pradėti nuo paruošto šablono ir jį pritaikyti savo tėvams.',
		personalParagraphThree: 'Jums nereikia filmuoti, montuoti ar įrašinėti balso. Užtenka parašyti sveikinimo tekstą, o video bus sugeneruotas automatiškai po apmokėjimo.',
		processParagraph: 'Kalėdinį video sveikinimą tėvams galite sukurti tiesiai naršyklėje. Ir tai padaryti galite vos per 3 žingsnius.',
		shareTitle: 'Patogu peržiūrėti, atsisiųsti ir nusiųsti tėvams',
		shareParagraphOne: 'Kai video sveikinimas paruošiamas, gaunate individualią nuorodą. Per ją galite peržiūrėti Kalėdų Senelio sveikinimą tėvams ir atsisiųsti video į savo įrenginį.',
		shareParagraphTwo: 'Su tėvams skirtu sveikinimu patogu pasidalinti žinute, el. paštu ar šeimos pokalbyje. Tai ypač naudinga, jei tėvai gyvena kitame mieste arba negalite susitikti per šventes.',
		shareParagraphThree: 'Video galima išsaugoti ir peržiūrėti dar kartą vėliau. Tai paprasta, greita ir asmeniška kalėdinė dovana tėvams, kuri palieka gražų šventinį prisiminimą.',
		exampleGreeting: 'Ho ho ho! Labas, mama ir tėti! Čia Kalėdų Senelis. Girdėjau, kad šiais metais vėl buvote pilni rūpesčio, meilės ir šilumos savo šeimai. Noriu jums padėkoti už viską, ką darote kiekvieną dieną. Linkiu jums ramių Kalėdų, daug šypsenų, jaukių akimirkų ir gražių metų priešakyje. Tegul šios šventės būna pilnos meilės, poilsio ir mažų stebuklų. Linksmų Kalėdų!',
		secondImage: '/images/sveikinimai/sveikinimai_kaledinis-sveikinimas-tevams_mama-ir-tetis-kartu-ziuri-kaledini-sveikinima.webp',
		secondImageAlt: "Mama ir tėtis kartu žiūri kalėdinį video sveikinimą telefone namuose",
		fourthImage: '/images/dovana/draugai-ziuri-kaledini-sveikinima.webp',
		fourthImageAlt: 'Draugai kartu žiūri kalėdinį video sveikinimą telefone jaukioje šventinėje aplinkoje',
	},
	{
		slug: 'kaledinis-sveikinimas-mokytojai',
		forWhom: 'mokytojai',
		withWhat: 'mokytojai skirtu',
		who: 'mokytoja',
		title: 'Kalėdinis sveikinimas mokytojai',
		description: 'Kalėdinis sveikinimas mokytojai. Sukurkite šiltą Kalėdų Senelio video sveikinimą mokytojai vos per kelias minutes nuo 6,99 €.',
		heroIntro: 'Personalizuotas Kalėdų Senelio video sveikinimas mokytojai. Įrašykite savo tekstą, pasirinkite video šabloną ir gaukite mokytojai skirtą šventinį sveikinimą vos per kelias minutes.',
		heroSecondParagraph: 'Tai paprasta ir jauki kalėdinė dovana mokytojai, kurią galima peržiūrėti telefone, planšetėje ar kompiuteryje. Registracija nereikalinga, o sveikinimą galima atsisiųsti ir pasidalinti su klase ar tėvais.',
		giftTitle: 'Puiki kalėdinė dovana mokytojai',
		giftParagraphOne: 'Kalėdinis video sveikinimas mokytojai yra šiltas būdas padėkoti už kantrybę, rūpestį ir darbą visus metus. Toks sveikinimas atrodo asmeniškiau nei paprasta žinutė ar standartinis atvirukas.',
		giftParagraphTwo: 'Toks sveikinimas tinka klasės auklėtojai, pradinių klasių mokytojai, dalyko mokytojai ar būrelio vadovei. Jį galima parodyti per klasės šventę, nusiųsti prieš Kalėdas arba padovanoti kartu su kita dovana.',
		personalTitle: 'Asmeniškas Kalėdų Senelio sveikinimas mokytojai',
		personalParagraphOne: 'Mokytojai skirtame sveikinime galite paminėti jos vardą, klasę, mokinių padėką, gražų metų prisiminimą ar šiltą palinkėjimą ateinantiems metams. Tokios detalės sveikinimą padaro nuoširdesnį.',
		personalParagraphTwo: 'Kalėdų Senelio video sveikinimas mokytojai gali būti šiltas, pagarbus arba lengvai linksmas. Tekstą galite parašyti patys arba pradėti nuo paruošto šablono ir jį pritaikyti savo mokytojai.',
		personalParagraphThree: 'Jums nereikia filmuoti, montuoti ar įrašinėti balso. Užtenka parašyti sveikinimo tekstą, o video bus sugeneruotas automatiškai po apmokėjimo.',
		processParagraph: 'Kalėdinį video sveikinimą mokytojai galite sukurti tiesiai naršyklėje. Ir tai padaryti galite vos per 3 žingsnius.',
		shareTitle: 'Patogu peržiūrėti, atsisiųsti ir nusiųsti mokytojai',
		shareParagraphOne: 'Kai video sveikinimas paruošiamas, gaunate individualią nuorodą. Per ją galite peržiūrėti Kalėdų Senelio sveikinimą mokytojai ir atsisiųsti video į savo įrenginį.',
		shareParagraphTwo: 'Su mokytojai skirtu sveikinimu patogu pasidalinti žinute, el. paštu ar klasės tėvų pokalbyje. Tai ypač naudinga, jei norite greitai ir gražiai pasveikinti mokytoją nuo visos klasės.',
		shareParagraphThree: 'Video galima išsaugoti ir peržiūrėti dar kartą vėliau. Tai paprasta, greita ir asmeniška kalėdinė dovana mokytojai, kuri palieka gražų šventinį prisiminimą.',
		exampleGreeting: 'Ho ho ho! Labas, mokytoja! Čia Kalėdų Senelis. Girdėjau, kad šiais metais buvote labai kantri, rūpestinga ir padėjote vaikams daug ko išmokti. Noriu jums padėkoti už šypsenas, gerumą ir visą darbą, kurį darote kiekvieną dieną. Linkiu ramių Kalėdų, gražių akimirkų su artimaisiais, gero poilsio ir daug džiaugsmo ateinančiais metais. Linksmų Kalėdų, mokytoja!',
		secondImage: '/images/sveikinimai/sveikinimai_kaledinis-sveikinimas-mokytojai_mokytoja-ziuri-kaledini-sveikinima-klaseje.webp',
		secondImageAlt: "Mokytoja klasėje žiūri kalėdinį video sveikinimą telefone",
		fourthImage: '/images/dovana/draugai-ziuri-kaledini-sveikinima.webp',
		fourthImageAlt: 'Draugai kartu žiūri kalėdinį video sveikinimą telefone jaukioje šventinėje aplinkoje',
	}
];

export function getGreetingSeoPageBySlug(slug: string): GreetingSeoPage | undefined {
	return seoPages.find((page) => page.slug === slug);
}