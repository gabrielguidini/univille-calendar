# Univille Calendar


## Authors

- [Gabriel Seroiska Guidini](https://github.com/gabrielguidini)
- [Ivan Gabriel Trapp](https://github.com/trappivan)
- [Juliano Sant'Anna Filho](https://github.com/julianosantannafilho)
- [Leandro Pinheiro Rosa](https://www.github.com/leaandropinheiro)

## Tech Stack

- **Client:** Vue e Vuetify
- **Server:** Java e Spring
- **Data Base:** Postgres

## Project Setup

```sh
docker compose up
```

## Project Data

```
insert into course (course_id,course_name,course_type)
values
    ('e600d92d-3b2f-43ed-866c-0949ed729789','Engenharia de Software',0),
    ('1f1f96e5-d8da-419e-9ee0-6601ccbd4baa','Sistema de Informacao',0),
    ('72a09954-0282-4556-b98c-41f074d5dea5','Analise e Desenvolviemento de Sistemas',1)

insert into teacher (teacher_id ,teacher_email, teacher_first_name, teacher_last_name)
values
    ('07ddae90-bdae-45d0-9878-f9ab5ffadf09','walter.coan@univille.br', 'Walter', 'Coan'),
    ('aebea8fb-58ac-467a-98f0-f666208d5424','leanderson.andre@univille.br', 'Leanderson', 'Andre'),
    ('a68b45d3-fcb0-4994-b560-fe38dbf20c6e','vanessa.collere@univille.br', 'Vanessa', 'Collere'),
    ('91953178-55de-4bbe-921a-7b715d425068','marcelo.pereira@univille.br', 'Marcelo', 'Pereira da Silva'),
    ('8d3bdc29-6f24-4295-bda7-2c00adaa8511','leila.techio@univille.br', 'Leila', 'Regina Techio'),
    ('29d6fa87-c353-4ddf-9492-01db52cc196c','paulo.bousfield@univille.br', 'Paulo', 'Bousfield')

insert into subject (subject_id, subject_name,course_course_id,teacher_teacher_id)
values
    ('436b62f4-cb02-428d-ad68-7f6517f6d9cb','Programacao Orientada a Objetos',null,null),
    ('eae4c45b-0d68-4515-9060-2e75fd74db92','Sistemas Operacionais',null,null),
    ('9ed945ad-6f71-4229-9ccd-d6cd44456170','Vivencias de Extensao',null,null),
    ('591abce8-a66c-474e-b89e-0ae9d150bc61','Etica e Legislacao em Computacao',null,null),
    ('150faecd-6837-4c8c-bb4d-f4aada634e8d','Fabrica de Software I' , null, null),
    ('8e378cb3-ed77-49b0-b0da-1d7457b14bd4','Trabalho de Conlcusao de Curso',null,null); 
```
