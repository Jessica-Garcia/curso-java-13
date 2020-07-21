package datahora;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class DataEHora {
    public static void main(String[] args) {


        //TODO -----------LocalDate------------

        // para criar uma data específica com mês em número (o mês começa em 1)

        LocalDate data = LocalDate.of(2020,7,18); // formato: 2020-07-18

        //para criar data com mês por escrito

        LocalDate nascimento = LocalDate.of(1991, Month.DECEMBER,16); //formato: 1991-12-16


        //para obter os dados da data:

        System.out.println("\nAno: " + data.getYear());
        System.out.println("Mês: " + data.getMonth()); // traz o mês por extenso
        System.out.println("Mês: " + data.getMonthValue()); // traz o numero correspondente ao mês
        System.out.println("Dia do mês: " + data.getDayOfMonth());
        System.out.println("Dia da semana: " + data.getDayOfWeek()); //traz o dia por extenso
        System.out.println("número de dias do mês de julho: " + data.lengthOfMonth());
        System.out.println("O ano é bissexto? " + data.isLeapYear());

        Month mes = data.getMonth();
        int ano = data.getYear();
        int mes2 = data.getMonthValue();
        int diaMes = data.getDayOfMonth();
        DayOfWeek diaDaSemana = data.getDayOfWeek();


        // para obter a data atual
        LocalDate hoje = LocalDate.now(); //formato: 2020-07-19


        //para adicionar dias, semanas, meses e anos à data

        LocalDate data3 = hoje.plusDays(3);
        LocalDate data4 = hoje.plusMonths(4);
        LocalDate data5 = hoje.plusWeeks(5);
        LocalDate data6 = hoje.plusYears(6);

        //para subtrair dias, semanas, meses e anos da data

        LocalDate data7 = hoje.minusDays(3);
        LocalDate data8 = hoje.minusMonths(4);
        LocalDate data9 = hoje.minusWeeks(5);
        LocalDate data10 = hoje.minusYears(6).plusDays(4).minusWeeks(2);


        //TODO ------------LocalTime-----------

        //para criar um horário específico:

        LocalTime h = LocalTime.of(23,15,10);

        //para obter os dados do horário:

        System.out.println("Hora: " + h.getHour());
        System.out.println("Minuto: " + h.getMinute());
        System.out.println("Segundo: " + h.getSecond());


        //para obter horário atual
        LocalTime agora = LocalTime.now();

        int hor = agora.getHour();
        int min = agora.getMinute();
        int seg = agora.getSecond();


        //TODO ------------LocalDateTime-----------

        //data e hora atuais:

        LocalDateTime dataHora = LocalDateTime.now(); //formato: 2020-07-19T22:27:48.884403


        //data e hora específicas:

        LocalDateTime dtHr = LocalDateTime.of(2020,07,19,11,04,10);


        // para adicionar um horário à uma data ja existente

        LocalDateTime dh = data.atTime(11,20,10);
        LocalDateTime dh2 = data.atTime(h);
        LocalDateTime dh3 = data.atTime(LocalTime.now());

        // para criar um LocalDateTime com data e hora já existentes:

        LocalDateTime ldt = LocalDateTime.of(data, h);

        //para adicionar uma data para um horário já existente

        LocalDateTime dh4 = h.atDate(data);
        LocalDateTime dh5 = h.atDate(LocalDate.now());
        LocalDateTime dh6 = h.atDate(LocalDate.of(2020,07,21));


        //TODO ------------Instant-----------

        //representa data e hora no GMT/UTC (fuso horário 0), formato: 2020-07-19T22:49:35.329457Z

        Instant instanteAtual = Instant.now(); //Instante atual no GMT 0;

        //para criar uma data a partir da quantidade de milissegundos a partir de 1 de janeiro de 1970 à meia noite

        Instant inicial = Instant.ofEpochMilli(500000000000l); // 1985-11-05T00:53:20Z

        //para calcular tempo entre os instantes (não admite anos e meses)

        Duration tempoTranscorrido = Duration.between(inicial, instanteAtual);
        System.out.println("Tempo transcorrido em horas: " + tempoTranscorrido.toHours());
        System.out.println("Tempo transcorrido em Dias: " + tempoTranscorrido.toDays());


        //TODO ------------ZonedDateTime-----------

        //apresenta informação de data e hora com fuso horário

        ZonedDateTime z = ZonedDateTime.now(); // formato: 2020-07-19T19:49:35.333506-03:00[America/Sao_Paulo]


        //para criar um ZonedDateTime com data e hora existentes e um zone id:

        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Australia/Sydney"));
        ZonedDateTime zdt2 = ZonedDateTime.of(data, h, ZoneId.of("Africa/Cairo"));


        //TODO ------------Period-----------
        //para representar intervalos entre datas, formato: P1Y5M1D

        Period p = Period.of(1, 5, 1);
        Period p2 = Period.ofDays(5);
        Period p3 = Period.ofMonths(6);
        Period p4 = Period.ofWeeks(5); // Não armazena semanas, Mostra semanas em dias, formato: P35D

        //TODO para calcular o intervalo entre duas datas

        Period intervaloDatas = Period.between(data, hoje);

        Period intervalo = data.until(hoje);

        Period idade = Period.between(nascimento, hoje); // formato: P28Y7M3D
        Period idade2 = nascimento.until(hoje); // formato: P28Y7M3D

        // para calcular intervalos de LocalDateTime com o Period, usar o toLocalDate()

        Period periodo = Period.between(dtHr.toLocalDate(), dataHora.toLocalDate());

        //para somar e subtrair dias, meses ou anos no Period

        Period intervaloDatas2 = intervaloDatas.plusDays(10);
        Period intervaloDatas3 = intervaloDatas.minusMonths(10);
        Period intervaloDatas4 = intervaloDatas.minusYears(10);


        //para somar um período em um LocalDate

        LocalDate l = data.plus(p);


        //TODO ------------Duration-----------
        //para representar intervalos de tempo

        //para criar duration

        Duration ofDays = Duration.ofDays(1); //  Dias são representados em horas, formato: PT24H

        Duration ofMinutes = Duration.ofMinutes(500); // formato: PT8H20M, minutos são representados em horas e minutos

        Duration ofSeconds = Duration.ofSeconds(500,50000); // formato: PT8M20.00005S

        //TODO -----para calcular intervalos de tempo-------

        Duration intervaloTempo = Duration.between(agora, h); //formato: PT2H10M8.641323S

        Long dura = intervaloTempo.toHours(); // formato: 2
        System.out.println(intervaloTempo.toDays()); // formato: 0
        System.out.println(intervaloTempo.getSeconds()); // formato: 9736


        //TODO ------para somar e subtrair horas, minutos e segundos-----

        Duration plusHours = intervaloTempo.plusHours(2);
        Duration minusHours = intervaloTempo.minusHours(2);

        Duration minusDays = intervaloTempo.minusDays(2); // valor em horas, formato: PT-45H-49M-51.358677S
        Duration plusDays = intervaloTempo.plusDays(2); //valor em horas, formato: PT50H10M8.641323S

        //TODO para calcular intervalos de LocalDateTime com o Duration, usar o toLocalTime()

        Duration dur = Duration.between(dtHr.toLocalTime(), dataHora.toLocalTime());// PT9H21M24.081437S


        //TODO ------------ChronoUnit-----------

        // Usada para medir o tempo em Anos, Meses, Semanas, Dias, Horas, Minutos, Segundos, Microssegundos, Nanossegundos

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime aniver = LocalDateTime.of(1991,12, 16, 8,30);

        System.out.println(ChronoUnit.DAYS.between(aniver, now));
        System.out.println(ChronoUnit.WEEKS.between(aniver, now));
        System.out.println(ChronoUnit.MONTHS.between(aniver, now));
        System.out.println(ChronoUnit.YEARS.between(aniver, now));
        System.out.println(ChronoUnit.HOURS.between(aniver, now));

        Long dias = ChronoUnit.DAYS.between(aniver, now);
        Long horas = ChronoUnit.HOURS.between(aniver, now);
        Long anos = ChronoUnit.YEARS.between(aniver, now);

        //TODO -Alterando atributos de datas

        LocalDate d = LocalDate.of(2020, Month.DECEMBER,16);

        System.out.println(d);

        //alterando o ano
        d = d.withYear(2021);

        //alterando o mês
        d = d.withMonth(Month.AUGUST.getValue());

        d = d.withMonth(10);

        //alterando o dia do mês

        d = d.withDayOfMonth(17);

        //TODO -Alterando atributos de horários

        LocalTime t = LocalTime.of(23,9,10);

        //alterando a hora
        t = t.withHour(15);

        //alterando o minuto
        t = t.withMinute(12);

        //alterando o segundo
        t = t.withSecond(45);

       //TODO ---------DateTimeFormatter------------

        //Classe para formatar datas, passar datas para String

        //Formatações no formato ISO, usado para transferir datas entre sistemas

        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME;

        LocalDateTime dataHoje = LocalDateTime.now();

        //passando a dataHoje para uma String nos formatos ISO_DATE_TIME, ISO_DATE e ISO_TIME

        String dataHojeFormat = isoDateTime.format(dataHoje); //formato padrão: 2020-07-20T12:13:01.139675
        String dataHojeFormat2 = isoDate.format(dataHoje); //formato padrão: 2020-07-20
        String dataHojeFormat3 = isoTime.format(dataHoje); //formato padrão: 12:16:32.099504

        //Outras formas de passar datas para String no formato ISO

        LocalDate date = LocalDate.now();
        String date1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); // formato: 20200720
        String date2 = date.format(DateTimeFormatter.ISO_DATE); // formato: 2020-07-20

        LocalDateTime dateTime = LocalDateTime.now();
        String dateTime1 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);// formato 2020-07-20T15:58:00.163972


        //Formatações para exibir para o usuário final

        // TODO ------------FormatStyle--------------
        //  Formatações Pré-definidas

        //OBS.a formatação com FormatStyle depende do Locale do sistema

        // para formatar somente a data

        DateTimeFormatter formatoShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String dataHojeFormat4 = formatoShort.format(dataHoje); //formato: 20/07/2020

        DateTimeFormatter formatoMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String dataHojeFormat6 = formatoMedium.format(dataHoje); //formato: 20 de jul de 2020


        // para formatar data e hora

        DateTimeFormatter formatoDataHoraShort = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String dataHojeFormat5 = formatoDataHoraShort.format(dataHoje); //formato: 20/07/2020 12:26

        DateTimeFormatter formatoDataHoraMedium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String dataHojeFormat7 = formatoDataHoraMedium.format(dataHoje); // formato: 20 de jul de 2020 12:36:32


        // para formatar ZonedDateTime, (Admite LONG e FULL)

        DateTimeFormatter formatoZonedLong = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String zonedFormat = formatoZonedLong.format(zonedDateTime); // formato: 20 de julho de 2020 12:40:58 BRT

        DateTimeFormatter formatoZonedFull = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        String zonedFormat2 = formatoZonedFull.format(zonedDateTime);//segunda-feira, 20 de julho de 2020 12:43:41 Horário Padrão de Brasília


        //TODO ------------ofPattern----------------
        // formatação personalizada

        // para LocalDateTime
        DateTimeFormatter formatoPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHojePattern = formatoPattern.format(dataHoje); //formato: 20/07/2020 13:29:07

        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataBR = LocalDate.now().format(formatoBR);


        // para fazer um parse de um formato específico, precisa passar o formato como argumento

        String dataBRString = "01/12/2020";
        LocalDate lo = LocalDate.parse(dataBRString, formatoBR);

        // para criar um formato passando um locale

        //MMMM mês por extenso

        DateTimeFormatter formatoFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);

        String dataFR = LocalDate.now().format(formatoFR);

        //fazendo o parse

        LocalDate parseFR = LocalDate.parse("20.juillet.2020", formatoFR);


        //TODO ----------------Parse---------------

        // Transforma String em Data (sem tratamento de exceção obrigatório)

        String date3 = "2020-07-20";
        LocalDate parseDate3 = LocalDate.parse(date3);


        //para transformar a String do tipo BASIC_ISO_DATE para LocalDate

        String date4 = "20200720";
        LocalDate parseData4 = LocalDate.parse(date4, DateTimeFormatter.BASIC_ISO_DATE);


        LocalDate parseData = LocalDate.parse("2020-07-19");
        LocalTime parseHora = LocalTime.parse("10:55:10");

        LocalDateTime parseDateTime = LocalDateTime.parse("2020-07-20T15:58:00.163972");


        // parse de um tipo mais genérico, é preciso passar para data, não precisa o tipo de formato como argumento

        TemporalAccessor parseDataHoje = formatoPattern.parse("20/07/2020 13:29:07");
        LocalDateTime parseFrom = LocalDateTime.from(parseDataHoje); // formato: 2020-07-20T13:29:07

        DateTimeFormatter formatoPatternHora = DateTimeFormatter.ofPattern("HH-mm-ss");
        TemporalAccessor parseHor = formatoPatternHora.parse("08-11-34");
        LocalTime parseFromHora = LocalTime.from(parseHor); // formato: 08:11:34

        //TODO ------------Comparação entre datas-------------------

        LocalDate passado = LocalDate.of(2017, Month.APRIL, 14);
        LocalDate presente = LocalDate.now();

        // para saber se uma data é depois da outra:

        boolean isAfter = passado.isAfter(presente);

        //para saber se uma data é antes da outra

        boolean isBefore = passado.isBefore(presente);

        // para saber se as datas são iguas

        boolean isEqual = passado.isEqual(presente);

        System.out.println(isEqual);

        //Para saber o perído entre as datas

        Period period = Period.between(passado, presente);

        System.out.println("perido somente em meses: " + period.toTotalMonths());
        System.out.println("perido em anos: " + period.getYears());
        System.out.println(period.getYears() + " anos, " + period.getMonths() + " meses e " + period.getDays() + " dias");

    }
}
