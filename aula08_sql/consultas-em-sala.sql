create table produtos(
	id SERIAL primary key,
	nome varchar(255),
	preco decimal(10, 2),
	estoque INT
);

-- medicos: id, nome, crm

create table medicos (
	id SERIAL primary key,
	nome varchar(255),
	crm varchar(255)
);

-- Inserir 3 produtos:

insert into produtos (nome, preco, estoque) values
('Geladeira', 4000.00, 100);

insert into produtos (nome, preco, estoque) values
('Ar-Condicionado', 4000.00, 100);


-- Selecionar os produtos cadastrados:

select * from produtos p;
select * from produtos p where estoque = 100;


-- criar uma tabela de fornecedores:

create table fornecedores (
	id SERIAL primary key,
	nome varchar(255),
	telefone varchar(255)
);

-- adicionar 2 fornecedores, um com ddd 83 e outro com ddd 81
	
insert into fornecedores (nome, telefone) values
('Guaraves', '(81) 999999999');

insert into fornecedores (nome, telefone) values
('Ambev', '(83) 7777777777');

-- selecionar os fornecedores:

select * from fornecedores f;

select * from fornecedores f where telefone like '%83%';


-- adicionar fornecedor_id dentro de produtos:

alter table produtos add column fornecedor_id INT;
alter table produtos add constraint fk_fornecedor
foreign key (fornecedor_id) references fornecedores(id);


-- crie a tabela especialidade_medica: id, nome
-- insira duas especialidades medicas
-- leve id_especialidade_medica para a tabela medicos


create table especialidade_medica (
	id SERIAL primary key,
	nome varchar(255)
);

insert into especialidade_medica (nome) values ('Cardiologia');
insert into especialidade_medica (nome) values ('Dermatologia');

select * from especialidade_medica;

alter table medicos add column especialidade_medica_id INT;
alter table medicos add constraint fk_especialidade_medica
foreign key (especialidade_medica_id) 
references especialidade_medica(id);



