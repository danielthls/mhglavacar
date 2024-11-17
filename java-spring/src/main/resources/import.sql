INSERT INTO tb_tipos_pagamento(nome, observacao) VALUES ('Pix', 'Pagamento via pix por QR Code ou chave aleatória');
INSERT INTO tb_tipos_pagamento(nome, observacao) VALUES ('Dinheiro', 'Verificar troco');
INSERT INTO tb_tipos_pagamento(nome, observacao) VALUES ('Cartão Débito', '');
INSERT INTO tb_tipos_pagamento(nome, observacao) VALUES ('Cartão Crédito', '');

INSERT INTO tb_municipios(nome, uf) VALUES ('Curitiba', 'PR');
INSERT INTO tb_municipios(nome, uf) VALUES ('São José dos Pinhais', 'PR');
INSERT INTO tb_municipios(nome, uf) VALUES ('Wenceslau Braz', 'PR');
INSERT INTO tb_municipios(nome, uf) VALUES ('Blumenau', 'SC');

INSERT INTO tb_pessoas(nome_pessoa, telefone, email, data_cadastro) VALUES ('João', '88888888', 'joao@mail.com', TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z');
INSERT INTO tb_pessoas(nome_pessoa, telefone, email, data_cadastro) VALUES ('Maria', '44444444', 'maria@mail.com', TIMESTAMP WITH TIME ZONE '2022-03-29T13:00:00Z');
INSERT INTO tb_pessoas(nome_pessoa, telefone, email, data_cadastro) VALUES ('Marcos', '22222222', 'marcos@mail.com', TIMESTAMP WITH TIME ZONE '2022-08-12T13:00:00Z');
INSERT INTO tb_pessoas(nome_pessoa, telefone, email, data_cadastro) VALUES ('Sabrina', '77777777', 'sabrina@mail.com', TIMESTAMP WITH TIME ZONE '2023-01-09T13:00:00Z');
INSERT INTO tb_pessoas(nome_pessoa, telefone, email, data_cadastro) VALUES ('Sabrina', '77777777', 'sabrina@mail.com', TIMESTAMP WITH TIME ZONE '2023-01-09T13:00:00Z');
INSERT INTO tb_pessoas(nome_pessoa, telefone, email, data_cadastro) VALUES ('Marcio Gil Thomaz', '41996084299', 'mhglavacar@mail.com', TIMESTAMP WITH TIME ZONE '2023-01-09T13:00:00Z');
INSERT INTO tb_pessoas(nome_pessoa) VALUES ('Admin');

INSERT INTO tb_enderecos(logradouro, numero, cep, complemento, referencia, id_municipio, id_pessoa) VALUES ('Rua do Bode', '12', '88999010', 'Apto 2', 'Na esquina', 1, 2);
INSERT INTO tb_enderecos(logradouro, numero, cep, complemento, referencia, id_municipio, id_pessoa) VALUES ('Rua da Vaca', '1243', '77222989', 'Casa 2', 'Perto do bar', 1, 3);
INSERT INTO tb_enderecos(logradouro, numero, cep, referencia, id_municipio, id_pessoa) VALUES ('Rua do Pombo', '42', '88999010', 'Do lado do Tadashi', 3, 1);
INSERT INTO tb_enderecos(logradouro, numero, cep, complemento, id_municipio, id_pessoa) VALUES ('Rua da Marmota', '8', '88999010', 'Apto 22', 2, 4);

INSERT INTO tb_usuarios(usuario, senha, id_pessoa) VALUES ('admin', '$2a$10$bU5MpTx98UHbCCE3I.71VuFKRghha9Gr8dyigcje1WbT7Wrw4M4NO', 5);
INSERT INTO tb_usuarios(usuario, senha, id_pessoa, data_cadastro) VALUES ('marcio','$2a$10$bU5MpTx98UHbCCE3I.71VuFKRghha9Gr8dyigcje1WbT7Wrw4M4NO', 6, '2024-11-16T21:12:00Z');

INSERT INTO tb_roles(authority) VALUES ('ROLE_ADMIN')
INSERT INTO tb_roles(authority) VALUES ('ROLE_GERENCIAL')
INSERT INTO tb_roles(authority) VALUES ('ROLE_OPERACIONAL')
INSERT INTO tb_roles(authority) VALUES ('ROLE_CLIENTE')

INSERT INTO tb_usuarios_roles(id_role, id_usuario) VALUES (1,1)
INSERT INTO tb_usuarios_roles(id_role, id_usuario) VALUES (2,1)
INSERT INTO tb_usuarios_roles(id_role, id_usuario) VALUES (3,1)
INSERT INTO tb_usuarios_roles(id_role, id_usuario) VALUES (4,1)
INSERT INTO tb_usuarios_roles(id_role, id_usuario) VALUES (2,2)
INSERT INTO tb_usuarios_roles(id_role, id_usuario) VALUES (3,2)
INSERT INTO tb_usuarios_roles(id_role, id_usuario) VALUES (4,2)



INSERT INTO tb_categorias(nome, descricao) VALUES ('Grande', 'Grandão');
INSERT INTO tb_categorias(nome, descricao) VALUES ('Médio', 'Mais ou menos');
INSERT INTO tb_categorias(nome, descricao) VALUES ('Pequeno', 'Pequeno');
INSERT INTO tb_categorias(nome, descricao) VALUES ('Moto', 'Motoca');

INSERT INTO tb_marcas(nome) VALUES ('Hyundai');
INSERT INTO tb_marcas(nome) VALUES ('Fiat');
INSERT INTO tb_marcas(nome) VALUES ('Wolkswagen');
INSERT INTO tb_marcas(nome) VALUES ('Honda');

INSERT INTO tb_veiculos(modelo, placa, cor, ano, id_pessoa, id_marca, id_categoria) VALUES ('HB20', 'AAA-2222', 'Cinza', 2020, 1, 1, 2);
INSERT INTO tb_veiculos(modelo, placa, cor, ano, id_pessoa, id_marca, id_categoria) VALUES ('Toro', 'BBB-4W21', 'Vermelho', 2024, 2, 2, 1);
INSERT INTO tb_veiculos(modelo, placa, cor, ano, id_pessoa, id_marca, id_categoria) VALUES ('Bis', 'CCC-7777', 'Rosa', 2010, 4, 4, 4);
INSERT INTO tb_veiculos(modelo, placa, cor, ano, id_pessoa, id_marca, id_categoria) VALUES ('Fusca', 'DDD-5555', 'Amarelo', 1978, 3, 3, 3);

INSERT INTO tb_servicos(nome, descricao) VALUES ('Lavagem simples', 'Ducha com água e sabão')
INSERT INTO tb_servicos(nome, descricao) VALUES ('Lavagem simples motor', 'Ducha com água e sabão motor')
INSERT INTO tb_servicos(nome, descricao) VALUES ('Polimento', 'Deixa o carro brilhando no escuro')
INSERT INTO tb_servicos(nome, descricao) VALUES ('Espelhamento', 'Deixa o carro brilhando mais ainda')

INSERT INTO tb_ordens_servico(hora_entrada, hora_saida, status, id_veiculo) VALUES (TIMESTAMP WITH TIME ZONE '2024-03-16T09:00:00Z', TIMESTAMP WITH TIME ZONE '2024-03-16T11:30:00Z', 1, 1)
INSERT INTO tb_ordens_servico(hora_entrada, status, id_veiculo) VALUES (TIMESTAMP WITH TIME ZONE '2024-03-16T09:00:00Z', 0, 3)
INSERT INTO tb_ordens_servico(hora_entrada, hora_saida, status, id_veiculo) VALUES (TIMESTAMP WITH TIME ZONE '2024-03-16T09:00:00Z', TIMESTAMP WITH TIME ZONE '2024-03-16T11:30:00Z', 3, 4)
INSERT INTO tb_ordens_servico(hora_entrada, hora_saida, status, id_veiculo) VALUES (TIMESTAMP WITH TIME ZONE '2024-03-16T09:00:00Z', TIMESTAMP WITH TIME ZONE '2024-03-16T11:30:00Z', 2, 2)

INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (1,1,70.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (1,2,60.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (1,3,50.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (1,4,40.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (2,1,90.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (2,2,80.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (2,3,70.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (2,4,60.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (3,1,300.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (3,2,280.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (3,3,250.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (3,4,210.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (4,1,500.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (4,2,460.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (4,3,410.0)
INSERT INTO tb_precos(id_servico, id_categoria, preco) VALUES (4,4,380.0)

INSERT INTO tb_pagamentos(momento,id_tipo_pagamento,id_ordem,numero_parcelas) VALUES (TIMESTAMP WITH TIME ZONE '2024-03-16T09:00:00Z',1,4,1)

INSERT INTO tb_parcelas_pagamento(data_vencimento, data_pagamento, numero_parcela, valor) VALUES (TIMESTAMP WITH TIME ZONE '2024-03-16T09:00:00Z', TIMESTAMP WITH TIME ZONE '2024-03-16T09:00:00Z',1, 890.0)

INSERT INTO tb_itens_ordem(id_servico, id_ordem, preco) VALUES (4,4, 500.0)
INSERT INTO tb_itens_ordem(id_servico, id_ordem, preco) VALUES (3,4, 300.0)
INSERT INTO tb_itens_ordem(id_servico, id_ordem, preco) VALUES (2,4, 90.0)
INSERT INTO tb_itens_ordem(id_servico, id_ordem, preco) VALUES (1,3, 50.0)
INSERT INTO tb_itens_ordem(id_servico, id_ordem, preco) VALUES (2,2, 60.0)
INSERT INTO tb_itens_ordem(id_servico, id_ordem, preco) VALUES (3,1, 280.0)

