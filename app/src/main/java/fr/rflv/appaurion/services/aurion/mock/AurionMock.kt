package fr.rflv.appaurion.services.aurion.mock

import fr.rflv.appaurion.services.aurion.interfaces.IAurion
import fr.rflv.appaurion.services.aurion.models.Course
import fr.rflv.appaurion.services.aurion.models.Mark
import fr.rflv.appaurion.services.aurion.models.Student
import kotlinx.datetime.LocalDateTime
import org.koin.core.annotation.Single


@Single
open class AurionMock : IAurion {

    override fun getAllCourses(): ArrayList<Course> {
        val courses = ArrayList<Course>();

        val course1 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 14, 9, 0)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 14, 12, 0)
            override val teachers: Array<String> = arrayOf("Vincent REYNAERT")
            override val students: Array<String> = arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B801")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Development - Unity 3D"
        }
        courses.add(course1);

        val course2 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 14, 12, 30)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 14, 13, 30)
            override val teachers: Array<String> = arrayOf("LAMBERT Yannick", "LITTON Evelyne")
            override val students: Array<String> = arrayOf("ADAM", "ADELER", "ALARAIDEH", "ALBERT", "ALLUARD", "ANDLER", "ARVELADZE", "AYEVEGHE BEKALE", "BAILLIEU", "BALDASSARRE", "BAPTISTE", "BARRAT", "BATTUT", "BEARD", "BELYAZID", "BENGLER", "BENNOUNA", "BERNARD", "BINANZER", "BLERVACQUE", "BLONDEAU", "BOAHENG", "BONNAFOUS", "BONTE", "BOUBERT", "BOUKEBIR", "BOUTOILLE", "BRELLE", "BUCHWALD", "CAPTAL", "CARAYOL", "CHANTALOUP", "CHARLET", "CHEN", "CHEN", "CHEVET", "COLIN", "CONRY", "CONTOIS", "COUCHY", "COUCHY", "COUSIN", "CRESPEL",
                "CUGNART", "DANSEL", "DEBAISIEUX", "DE CORDOBA GOZALVEZ", "DEFEVER", "DEFFRENNES",
                "DEFOUG", "DELCOURT", "DELEHONTE", "DELESTRET", "DELOBEL", "DELPIERRE", "DELRUE", "DELZENNE", "DEMAY", "DEMNATI", "DENOULET",
                "DESMYTTERE", "DESSENNE", "D'HARCOURT", "DIALLO", "DOUCHET", "DUBUS", "DUCOULOMBIER", "DUCROCQ", "DUHAMEL", "DUMAS", "DUPREZ", "DUVERGER",
                "EISELE", "EL ABDELLAOUI", "ESCAFFRE", "FAGOT", "FERJAULT", "FESARD", "FILIPOVIC", "FLEURY - LE VESO", "FOURNET",
                "FREVAL", "GARCIA", "GENEAU DE LAMARLIERE", "GEORGES", "GIRAUD", "GOUTORBE", "GROUX", "HAEGMAN", "HENEMAN", "HENSGEN",
                "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Réunion"
            override val rooms: Array<String> = arrayOf("ISEN_C304_H")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Réunion"
        }
        courses.add(course2);

        val course3 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 14, 13, 30)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 14, 17, 30)
            override val teachers: Array<String> = arrayOf("REYNAERT Vincent")
            override val students: Array<String> = arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B801")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Development - Unity 3D"
        }
        courses.add(course3);

        val course4 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 15, 8, 0)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 15, 10, 30)
            override val teachers: Array<String> = arrayOf("BEN AHMED Elhem")
            override val students: Array<String> = arrayOf("BRELLE", "BUCHWALD", "CAPTAL", "CARAYOL", "CHANTALOUP", "CONTOIS"
                , "COUCHY", "COUROUBLE", "COUSIN", "CRESPEL", "CUGNART", "DEFEVER", "DEFFRENNES", "DEFOUG", "DELEHONTE",
                "DELPIERRE", "DELRUE", "DELZENNE", "DEMAY", "DEMNATI", "GOUTORBE", "HENSGEN","HER", "HERBIN", "HORNAIN",
                "HUL", "IGUIDER", "ITLY", "JADID", "JAMELOT", "JASPART", "JEAN-DE-DIEU", "KLEIN", "KLOPOCKI", "LAROUZIERE",
                "LEBRUN", "LEFEBVRE", "LEGRAND", "LEMAITRE", "LEPERS", "LOOS", "MAAROUF", "MACKOWIAK", "MACKOWIAK",
                "MARCHAND", "MARIAGE", "MILLIEN", "MONTEGNIES", "PARMENTIER", "PIEKARZ", "POTEZ", "REYNAL DE SAINT MICHEL",
                "SAUVAGE", "TALHA", "VAN HONACKER", "VERBEKE", "VEROLLEMAN", "YOUSSEFI", "ZERRARI")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISA_SALLE_NS_093")
            override val groups: Array<String> = arrayOf("M1- Contrôle de Gestion - Groupe A")
            override val name: String = "Module FHES Contrôle de Gestion"
        }
        courses.add(course4);

        val course5 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 15, 10, 20)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 15, 12, 25)
            override val teachers: Array<String> = arrayOf("COATES Antony")
            override val students: Array<String> = arrayOf("BRELLE", "BUCHWALD", "CAPTAL", "CARAYOL", "CHANTALOUP", "CONTOIS"
                , "COUCHY", "COUROUBLE", "COUSIN", "CRESPEL", "CUGNART", "DEFEVER", "DEFFRENNES", "DEFOUG", "DELEHONTE",
                "DELPIERRE", "DELRUE", "DELZENNE", "DEMAY", "DEMNATI", "GOUTORBE")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_B804_H")
            override val groups: Array<String> = arrayOf("M1 - Anglais Communication Skills Groupe A (niv B2 déjà)")
            override val name: String = "Module d'Anglais "
        }
        courses.add(course5);

        val course6 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 15, 13, 30)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 15, 17, 15)
            override val teachers: Array<String> = arrayOf("IHADDADENE Nacim")
            override val students: Array<String> = arrayOf("ALARAIDEH", "BALDASSARRE", "BATTUT", "BERNARD", "BINANZER",
                "BOUKEBIR", "CAPTAL", "DEBAISIEUX", "DEFFRENNES", "DIALLO", "DUHAMEL", "ESCAFFRE", "FILIPOVIC", "FLEURY - LE VESO",
                "GIRAUD", "GROUX", "HENEMAN", "HER", "HERBEAU", "KAFANDO", "LAROUZIERE", "LJUBOJEVIC", "LORIDAN", "MANOUVRIEZ", "MAURY"
                , "PIEKARZ", "RADOICIC", "SANON", "SAUVAGE", "SCHNEIDER", "SEREUSE", "SINGEOT-SOUSA", "TCHUEM TCHUENTE", "THILLOU", "TOURNEUR",
                "T'SERSTEVENS", "VANDERHAEGEN", "VAN HONACKER", "VEROONE", "VILAIN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("ISEN_C304_H")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module de Base Intelligence Artificielle"
        }
        courses.add(course6);

        val course7 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 16, 9, 0)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 16, 12, 0)
            override val teachers: Array<String> = arrayOf("ESTEVES Aurélien")
            override val students: Array<String> = arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("Chez Pole IIID")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Network"
        }
        courses.add(course7);

        val course8 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 16, 13, 30)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 16, 17, 30)
            override val teachers: Array<String> = arrayOf("ESTEVES Aurélien")
            override val students: Array<String> = arrayOf("CRESPEL", "DEFFRENNES", "HER", "SEREUSE", "VANDERHAEGEN")
            override val courseType: String = "Cours/TD"
            override val rooms: Array<String> = arrayOf("Chez Pole IIID")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module Game Network"
        }
        courses.add(course8);

        val course9 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 17, 13, 30)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 17, 15, 30)
            override val teachers: Array<String> = arrayOf("HABIB Carol", "SALIM Christian")
            override val students: Array<String> = arrayOf("BRELLE", "BUCHWALD", "CAPTAL", "CARAYOL", "CHANTALOUP", "CONTOIS"
                , "COUCHY", "COUROUBLE", "COUSIN", "CRESPEL", "CUGNART", "DEFEVER", "DEFFRENNES", "DEFOUG", "DELEHONTE",
                "DELPIERRE", "DELRUE", "DELZENNE", "DEMAY", "DEMNATI", "GOUTORBE", "HENSGEN","HER", "HERBIN", "HORNAIN",
                "HUL", "IGUIDER", "ITLY", "JADID", "JAMELOT", "JASPART", "JEAN-DE-DIEU", "KLEIN", "KLOPOCKI", "LAROUZIERE",
                "LEBRUN", "LEFEBVRE", "LEGRAND", "LEMAITRE", "LEPERS", "LOOS", "MAAROUF", "MACKOWIAK", "MACKOWIAK",
                "MARCHAND", "MARIAGE", "MILLIEN", "MONTEGNIES", "PARMENTIER", "PIEKARZ", "POTEZ", "REYNAL DE SAINT MICHEL",
                "SAUVAGE", "TALHA", "VAN HONACKER", "VERBEKE", "VEROLLEMAN", "YOUSSEFI", "ZERRARI")
            override val courseType: String = "Partiel avec Surveillance"
            override val rooms: Array<String> = arrayOf("ISEN_C304_H")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module de Base Python Scripting"
        }
        courses.add(course9);

        val course10 = object : Course {
            override val start: LocalDateTime = LocalDateTime(2022, 11, 18, 13, 30)
            override val end: LocalDateTime = LocalDateTime(2022, 11, 17, 15, 30)
            override val teachers: Array<String> = arrayOf("HABIB Carol", "SALIM Christian")
            override val students: Array<String> = arrayOf("BRELLE", "BUCHWALD", "CAPTAL", "CARAYOL", "CHANTALOUP", "CONTOIS"
                , "COUCHY", "COUROUBLE", "COUSIN", "CRESPEL", "CUGNART", "DEFEVER", "DEFFRENNES", "DEFOUG", "DELEHONTE",
                "DELPIERRE", "DELRUE", "DELZENNE", "DEMAY", "DEMNATI", "GOUTORBE", "HENSGEN","HER", "HERBIN", "HORNAIN",
                "HUL", "IGUIDER", "ITLY", "JADID", "JAMELOT", "JASPART", "JEAN-DE-DIEU", "KLEIN", "KLOPOCKI", "LAROUZIERE",
                "LEBRUN", "LEFEBVRE", "LEGRAND", "LEMAITRE", "LEPERS", "LOOS", "MAAROUF", "MACKOWIAK", "MACKOWIAK",
                "MARCHAND", "MARIAGE", "MILLIEN", "MONTEGNIES", "PARMENTIER", "PIEKARZ", "POTEZ", "REYNAL DE SAINT MICHEL",
                "SAUVAGE", "TALHA", "VAN HONACKER", "VERBEKE", "VEROLLEMAN", "YOUSSEFI", "ZERRARI")
            override val courseType: String = "Partiel avec Surveillance"
            override val rooms: Array<String> = arrayOf("ISEN_C304_H")
            override val groups: Array<String> = arrayOf("Promotion 2ème année de Cycle Ingénieur (M1) 2022-2023")
            override val name: String = "Module de Base Python Scripting"
        }
        courses.add(course10);

        return courses;
    }

    override fun getAllMarks(): ArrayList<Mark> {
        return ArrayList<Mark>();
    }

    override fun getAllStudents(): ArrayList<Student> {
        return ArrayList<Student>();
    }
}