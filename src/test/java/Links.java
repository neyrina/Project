public enum Links {
    COURSE1("https://otus.ru/lessons/qa-game/?int_source=courses_catalog&int_term=testing"),
    COURSE2("https://otus.ru/lessons/qa-engineer/?int_source=courses_catalog&int_term=testing"),
    COURSE3("https://otus.ru/lessons/loadqa/?int_source=courses_catalog&int_term=testing"),
    COURSE4("https://otus.ru/lessons/java-qa-pro/?int_source=courses_catalog&int_term=testing"),
    COURSE5("https://otus.ru/lessons/avtomatizaciya-web-testirovaniya/?int_source=courses_catalog&int_term=testing"),
    COURSE6("https://otus.ru/lessons/qa-auto-java-specialization/?int_source=courses_catalog&int_term=testing"),
    COURSE7("https://otus.ru/lessons/java-qa-basic/?int_source=courses_catalog&int_term=testing"),
    COURSE8("https://otus.ru/lessons/qa-lead/?int_source=courses_catalog&int_term=testing"),
    COURSE9("https://otus.ru/lessons/qajs/?int_source=courses_catalog&int_term=testing"),
    COURSE10("https://otus.ru/lessons/kotlin-qa-engineer/?int_source=courses_catalog&int_term=testing"),
    COURSE11("https://otus.ru/online/manualtesting/");



    private final String value;
    Links (String value) {
        this.value = value;
    }

    public static Links fetchValue(String constant) {
        for (Links link : Links.values()) {
            if (link.value.equals(constant)) {
                return link;
            }
        }
        return null;
    }

}
