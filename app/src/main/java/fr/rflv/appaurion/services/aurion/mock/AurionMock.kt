package fr.rflv.appaurion.services.aurion.mock

import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.data.Mark
import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.models.ICourse
import fr.rflv.appaurion.services.aurion.models.IMark
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import org.koin.core.annotation.Single


@Single
open class AurionMock : IAurion {
    override fun login(username: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAllCourses(): List<Course> {
        val cours = mutableListOf<Course>();

        val ICourse1 = Course(object : ICourse {
            override val id = "1"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 14, 9, 0)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 14, 12, 0)
            override val teachers: Array<String> = arrayOf("Vincent REYNAERT")
            override val students: Array<String> =
                arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B801")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Development - Unity 3D"
        })
        cours.add(ICourse1);

        val ICourse2 = Course(object : ICourse {
            override val id = "2"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 14, 12, 30)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 14, 13, 30)
            override val teachers: Array<String> = arrayOf("LAMBERT Yannick", "LITTON Evelyne")
            override val students: Array<String> = arrayOf(
                "ADAM",
                "ADELER",
                "ALARAIDEH",
                "ALBERT",
                "ALLUARD",
                "ANDLER",
                "ARVELADZE",
                "AYEVEGHE BEKALE",
                "BAILLIEU",
                "BALDASSARRE",
                "BAPTISTE",
                "BARRAT",
                "BATTUT",
                "BEARD",
                "BELYAZID",
                "BENGLER",
                "BENNOUNA",
                "BERNARD",
                "BINANZER",
                "BLERVACQUE",
                "BLONDEAU",
                "BOAHENG",
                "BONNAFOUS",
                "BONTE",
                "BOUBERT",
                "BOUKEBIR",
                "BOUTOILLE",
                "BRELLE",
                "BUCHWALD",
                "CAPTAL",
                "CARAYOL",
                "CHANTALOUP",
                "CHARLET",
                "CHEN",
                "CHEN",
                "CHEVET",
                "COLIN",
                "CONRY",
                "CONTOIS",
                "COUCHY",
                "COUCHY",
                "COUSIN",
                "CRESPEL",
                "CUGNART",
                "DANSEL",
                "DEBAISIEUX",
                "DE CORDOBA GOZALVEZ",
                "DEFEVER",
                "DEFFRENNES",
                "DEFOUG",
                "DELCOURT",
                "DELEHONTE",
                "DELESTRET",
                "DELOBEL",
                "DELPIERRE",
                "DELRUE",
                "DELZENNE",
                "DEMAY",
                "DEMNATI",
                "DENOULET",
                "DESMYTTERE",
                "DESSENNE",
                "D'HARCOURT",
                "DIALLO",
                "DOUCHET",
                "DUBUS",
                "DUCOULOMBIER",
                "DUCROCQ",
                "DUHAMEL",
                "DUMAS",
                "DUPREZ",
                "DUVERGER",
                "EISELE",
                "EL ABDELLAOUI",
                "ESCAFFRE",
                "FAGOT",
                "FERJAULT",
                "FESARD",
                "FILIPOVIC",
                "FLEURY - LE VESO",
                "FOURNET",
                "FREVAL",
                "GARCIA",
                "GENEAU DE LAMARLIERE",
                "GEORGES",
                "GIRAUD",
                "GOUTORBE",
                "GROUX",
                "HAEGMAN",
                "HENEMAN",
                "HENSGEN",
                "HER",
                "SEREUSE",
                "VANDERHAEGEN"
            )
            override val courseType: String = "Réunion"
            override val rooms: Array<String> = arrayOf("ISEN_C304_H")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Réunion"
        })
        cours.add(ICourse2);

        val ICourse3 = Course(object : ICourse {
            override val id = "3"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 14, 13, 30)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 14, 17, 30)
            override val teachers: Array<String> = arrayOf("REYNAERT Vincent")
            override val students: Array<String> =
                arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B801")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Development - Unity 3D"
        })
        cours.add(ICourse3);

        val ICourse4 = Course(object : ICourse {
            override val id = "4"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 15, 8, 0)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 15, 10, 30)
            override val teachers: Array<String> = arrayOf("BEN AHMED Elhem")
            override val students: Array<String> = arrayOf(
                "BRELLE",
                "BUCHWALD",
                "CAPTAL",
                "CARAYOL",
                "CHANTALOUP",
                "CONTOIS",
                "COUCHY",
                "COUROUBLE",
                "COUSIN",
                "CRESPEL",
                "CUGNART",
                "DEFEVER",
                "DEFFRENNES",
                "DEFOUG",
                "DELEHONTE",
                "DELPIERRE",
                "DELRUE",
                "DELZENNE",
                "DEMAY",
                "DEMNATI",
                "GOUTORBE",
                "HENSGEN",
                "HER",
                "HERBIN",
                "HORNAIN",
                "HUL",
                "IGUIDER",
                "ITLY",
                "JADID",
                "JAMELOT",
                "JASPART",
                "JEAN-DE-DIEU",
                "KLEIN",
                "KLOPOCKI",
                "LAROUZIERE",
                "LEBRUN",
                "LEFEBVRE",
                "LEGRAND",
                "LEMAITRE",
                "LEPERS",
                "LOOS",
                "MAAROUF",
                "MACKOWIAK",
                "MACKOWIAK",
                "MARCHAND",
                "MARIAGE",
                "MILLIEN",
                "MONTEGNIES",
                "PARMENTIER",
                "PIEKARZ",
                "POTEZ",
                "REYNAL DE SAINT MICHEL",
                "SAUVAGE",
                "TALHA",
                "VAN HONACKER",
                "VERBEKE",
                "VEROLLEMAN",
                "YOUSSEFI",
                "ZERRARI"
            )
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISA_SALLE_NS_093")
            override val groups: Array<String> = arrayOf("M1- Contrôle de Gestion - Groupe A")
            override val name: String = "Module FHES Contrôle de Gestion"
        })
        cours.add(ICourse4);

        val ICourse5 = Course(object : ICourse {
            override val id = "5"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 15, 10, 20)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 15, 12, 25)
            override val teachers: Array<String> = arrayOf("COATES Antony")
            override val students: Array<String> = arrayOf(
                "BRELLE",
                "BUCHWALD",
                "CAPTAL",
                "CARAYOL",
                "CHANTALOUP",
                "CONTOIS",
                "COUCHY",
                "COUROUBLE",
                "COUSIN",
                "CRESPEL",
                "CUGNART",
                "DEFEVER",
                "DEFFRENNES",
                "DEFOUG",
                "DELEHONTE",
                "DELPIERRE",
                "DELRUE",
                "DELZENNE",
                "DEMAY",
                "DEMNATI",
                "GOUTORBE"
            )
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B804_H")
            override val groups: Array<String> =
                arrayOf("M1 - Anglais Communication Skills Groupe A (niv B2 déjà)")
            override val name: String = "Module d'Anglais "
        })
        cours.add(ICourse5);

        val ICourse6 = Course(object : ICourse {
            override val id = "6"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 15, 13, 30)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 15, 17, 15)
            override val teachers: Array<String> = arrayOf("IHADDADENE Nacim")
            override val students: Array<String> = arrayOf(
                "ALARAIDEH",
                "BALDASSARRE",
                "BATTUT",
                "BERNARD",
                "BINANZER",
                "BOUKEBIR",
                "CAPTAL",
                "DEBAISIEUX",
                "DEFFRENNES",
                "DIALLO",
                "DUHAMEL",
                "ESCAFFRE",
                "FILIPOVIC",
                "FLEURY - LE VESO",
                "GIRAUD",
                "GROUX",
                "HENEMAN",
                "HER",
                "HERBEAU",
                "KAFANDO",
                "LAROUZIERE",
                "LJUBOJEVIC",
                "LORIDAN",
                "MANOUVRIEZ",
                "MAURY",
                "PIEKARZ",
                "RADOICIC",
                "SANON",
                "SAUVAGE",
                "SCHNEIDER",
                "SEREUSE",
                "SINGEOT-SOUSA",
                "TCHUEM TCHUENTE",
                "THILLOU",
                "TOURNEUR",
                "T'SERSTEVENS",
                "VANDERHAEGEN",
                "VAN HONACKER",
                "VEROONE",
                "VILAIN"
            )
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_C304_H")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module de Base Intelligence Artificielle"
        })
        cours.add(ICourse6);

        val ICourse7 = Course(object : ICourse {
            override val id = "7"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 16, 9, 0)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 16, 12, 0)
            override val teachers: Array<String> = arrayOf("ESTEVES Aurélien")
            override val students: Array<String> =
                arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("Chez Pole IIID")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Network"
        })
        cours.add(ICourse7);

        val ICourse8 = Course(object : ICourse {
            override val id = "8"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 16, 13, 30)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 16, 17, 30)
            override val teachers: Array<String> = arrayOf("ESTEVES Aurélien")
            override val students: Array<String> =
                arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("Chez Pole IIID")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Network"
        })
        cours.add(ICourse8);

        val ICourse9 = Course(object : ICourse {
            override val id = "9"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 17, 13, 30)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 17, 15, 30)
            override val teachers: Array<String> = arrayOf("HABIB Carol", "SALIM Christian")
            override val students: Array<String> = arrayOf(
                "BRELLE",
                "BUCHWALD",
                "CAPTAL",
                "CARAYOL",
                "CHANTALOUP",
                "CONTOIS",
                "COUCHY",
                "COUROUBLE",
                "COUSIN",
                "CRESPEL",
                "CUGNART",
                "DEFEVER",
                "DEFFRENNES",
                "DEFOUG",
                "DELEHONTE",
                "DELPIERRE",
                "DELRUE",
                "DELZENNE",
                "DEMAY",
                "DEMNATI",
                "GOUTORBE",
                "HENSGEN",
                "HER",
                "HERBIN",
                "HORNAIN",
                "HUL",
                "IGUIDER",
                "ITLY",
                "JADID",
                "JAMELOT",
                "JASPART",
                "JEAN-DE-DIEU",
                "KLEIN",
                "KLOPOCKI",
                "LAROUZIERE",
                "LEBRUN",
                "LEFEBVRE",
                "LEGRAND",
                "LEMAITRE",
                "LEPERS",
                "LOOS",
                "MAAROUF",
                "MACKOWIAK",
                "MACKOWIAK",
                "MARCHAND",
                "MARIAGE",
                "MILLIEN",
                "MONTEGNIES",
                "PARMENTIER",
                "PIEKARZ",
                "POTEZ",
                "REYNAL DE SAINT MICHEL",
                "SAUVAGE",
                "TALHA",
                "VAN HONACKER",
                "VERBEKE",
                "VEROLLEMAN",
                "YOUSSEFI",
                "ZERRARI"
            )
            override val courseType: String = "Partiel avec Surveillance"
            override val rooms: Array<String> = arrayOf("ISEN_C304_H")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module de Base Python Scripting"
        })
        cours.add(ICourse9);

        val ICourse10 = Course(object : ICourse {
            override val id = "10"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 18, 10, 20)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 18, 12, 25)
            override val teachers: Array<String> = arrayOf("COATES Anthony")
            override val students: Array<String> = arrayOf(
                "ARVELADZE",
                "BATTUT",
                "BERNARD",
                "BRELLE",
                "DEBAISIEUX",
                "DE CORDOBA GOZALVEZ",
                "GEORGES",
                "GIRAUD",
                "GUIRAUD",
                "HENEMAN",
                "IGUIDER",
                "DEFEVER",
                "DEFFRENNES",
                "ITLY",
                "JADID",
                "LAROUZIERE",
                "LEFEBVRE",
                "LEMAITRE",
                "LORIDAN",
                "NABILI",
                "NKOUONJOM YAIN",
                "PIEKARZ",
                "ROUBISCOUL",
                "SALCEDO LEÓN",
                "SAUVAGE",
                "SEREUSE",
                "THILLOU",
                "TOURNEUR",
                "T'SERSTEVENS",
                "TSOY",
                "VANDERHAEGEN",
                "VANWORMHOUDT",
                "VILLAIN",
                "ZAWADZKI",
                "VAN HONACKER",
                "YOUSSEFI"
            )
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_A919")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module d'Ouverture Intercultural Communication (S1)"
        })
        cours.add(ICourse10);

        val ICourse11 = Course(object : ICourse {
            override val id = "11"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 18, 13, 30)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 18, 17, 15)
            override val teachers: Array<String> = arrayOf("BENABBAS Yassine")
            override val students: Array<String> = arrayOf(
                "BAPTISTE", "BONNAFOUS",
                "CHARLET", "CHEVET", "CONTOIS", "COUSIN", "CRESPEL", "DEFFRENNES",
                "DELESTRET", "DELPIERRE", "DUMAS", "DUVERGER", "FLEURY - LE VESO",
                "FOURNET", "GROUX", "HER", "JASPART", "MARCHAND", "MAREEL", "MARIAGE",
                "MILLIEN", "PAWLICKI", "PETIT", "PIVETTE", "POTEZ", "RASCLE", "SINGEOT-SOUSA",
                "SMETS", "TALIB", "THUILLIER", "VANBAELINGHEM", "VANDERHAEGEN", "VERBEKE",
                "VILLAIN", "YANG", "YOUSSEFI", "ZHOU"
            )
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_A919")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module de Base Développement Android"
        })
        cours.add(ICourse11);

        val ICourse12 = Course(object : ICourse {
            override val id = "12"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 21, 9, 0)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 21, 12, 0)
            override val teachers: Array<String> = arrayOf("Vincent REYNAERT")
            override val students: Array<String> =
                arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B801")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Development - Unity 3D"
        })
        cours.add(ICourse12);

        val ICourse13 = Course(object : ICourse {
            override val id = "12"
            override val startDateTime: LocalDateTime = LocalDateTime(2022, 11, 21, 13, 30)
            override val endDateTime: LocalDateTime = LocalDateTime(2022, 11, 21, 17, 30)
            override val teachers: Array<String> = arrayOf("Vincent REYNAERT")
            override val students: Array<String> =
                arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B801")
            override val groups: Array<String> =
                arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Development - Unity 3D"
        })
        cours.add(ICourse13);

        return cours;
    }

    override fun getAllMarks(): List<Mark> {
        val IMarks = mutableListOf<Mark>();

        val IMark1 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 6, 21)
            override val id: String = "2122_ISEN_3A_S2_PROJET_DEV_LOGICIEL_EVAL"
            override val name: String = "Evaluation du Projet Développement Logiciel"
            override val mark: Float = 18.00f
            override val coefficient: Number = 1
        })
        IMarks.add(IMark1);

        val IMark2 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 5, 19)
            override val id: String = "2122_ISEN_3A_S2_AUTOMATIQUE_PARTIEL"
            override val name: String = "Partiel d'Automatique"
            override val mark: Float = 12.00f
            override val coefficient: Number = 100
        })
        IMarks.add(IMark2);

        val IMark3 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 5, 18)
            override val id: String = "\t2122_ISEN_3A_S2_INFO_BDD_RES_PARTIEL"
            override val name: String = "Partiel d'Informatique - Base de Données et Réseaux"
            override val mark: Float = 14.15f
            override val coefficient: Number = 100
        })
        IMarks.add(IMark3);

        val IMark4 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 5, 18)
            override val id: String = "2122_ISEN_3A_S2_SYSELEC_PARTIEL"
            override val name: String = "Partiel de Systèmes Electroniques"
            override val mark: Float = 8.74f
            override val coefficient: Number = 100
        })
        IMarks.add(IMark4);

        val IMark5 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 5, 17)
            override val id: String = "2122_ISEN_3A_S2_PSOL_PARTIEL"
            override val name: String = "Partiel de Physique du Solide"
            override val mark: Float = 14.50f
            override val coefficient: Number = 100
        })
        IMarks.add(IMark5);

        val IMark6 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 5, 16)
            override val id: String = "2122_ISEN_3A_S2_ANSIGIM_PARTIEL"
            override val name: String = "Partiel d'Analyse des Signaux et des Images"
            override val mark: Float = 20.00f
            override val coefficient: Number = 100
        })
        IMarks.add(IMark6);

        val IMark7 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 5, 16)
            override val id: String = "2122_ISEN_3A_S2_ANSIGIM_TP"
            override val name: String =
                "Evaluation des Travaux Pratiques d'Analyse des Signaux et des Images"
            override val mark: Float = 19.00f
            override val coefficient: Number = 100
        })
        IMarks.add(IMark7);

        val IMark8 = Mark(object : IMark {
            override val date: LocalDate = LocalDate(2022, 5, 16)
            override val id: String = "2122_ISEN_3A_S2_ECO_PARTIEL"
            override val name: String = "Partiel d'économie d'entreprise"
            override val mark: Float = 15.00f
            override val coefficient: Number = 1
        })
        IMarks.add(IMark8);

        return IMarks;
    }

    override fun hasSavedLogins(): Boolean {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}