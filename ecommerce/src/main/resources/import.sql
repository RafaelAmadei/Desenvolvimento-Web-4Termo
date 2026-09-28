INSERT INTO categoria (nome, descricao) VALUES ('Livros', 'Livros Técnicos');
INSERT INTO categoria (nome, descricao) VALUES ('Eletrónica', 'Smartphones, TVs e Gadgets');
INSERT INTO categoria (nome, descricao) VALUES ('Informática', 'Computadores, Portáteis e Periféricos');
INSERT INTO categoria (nome, descricao) VALUES ('Eletrodomésticos', 'Frigoríficos, Fogões e Máquinas');
INSERT INTO categoria (nome, descricao) VALUES ('Móveis', 'Sofás, Mesas e Cadeiras');

INSERT INTO produto (nome, descricao, estoque, preco, categoria_id)
VALUES ('Livro Java', 'Livro sobre programação Java', 50, 80.00, 1);

INSERT INTO produto (nome, descricao, estoque, preco, categoria_id)
VALUES ('Smartphone S23', 'Galaxy S23 256GB', 30, 4500.00, 2);

INSERT INTO produto (nome, descricao, estoque, preco, categoria_id)
VALUES ('Notebook Dell', 'Inspiron 15 8GB 256GB SSD', 20, 3200.00, 3);

INSERT INTO produto (nome, descricao, estoque, preco, categoria_id)
VALUES ('Frigorífico', 'Frost Free 400L', 15, 3800.00, 4);

INSERT INTO produto (nome, descricao, estoque, preco, categoria_id)
VALUES ('Sofá Retrátil', '3 Lugares', 10, 1500.00, 5);

INSERT INTO cliente (nome, email, telefone)
VALUES ('João Silva', 'joao@email.com', '11999991111');

INSERT INTO cliente (nome, email, telefone)
VALUES ('Maria Oliveira', 'maria@email.com', '11988882222');

INSERT INTO cliente (nome, email, telefone)
VALUES ('Carlos Santos', 'carlos@email.com', '11977773333');

INSERT INTO cliente (nome, email, telefone)
VALUES ('Ana Costa', 'ana@email.com', '11966664444');

INSERT INTO cliente (nome, email, telefone)
VALUES ('Pedro Almeida', 'pedro@email.com', '11955555555');

INSERT INTO pedido (data, status, valor_total, cliente_id)
VALUES ('2023-10-01 10:30:00', 'AGUARDANDO', 4500.00, 1);

INSERT INTO pedido (data, status, valor_total, cliente_id)
VALUES ('2023-10-02 14:15:00', 'PAGO', 3200.00, 2);

INSERT INTO pedido (data, status, valor_total, cliente_id)
VALUES ('2023-10-03 09:00:00', 'ENVIADO', 2500.00, 3);

INSERT INTO pedido (data, status, valor_total, cliente_id)
VALUES ('2023-10-04 16:45:00', 'ENTREGUE', 3800.00, 4);

INSERT INTO pedido (data, status, valor_total, cliente_id)
VALUES ('2023-10-05 11:20:00', 'CANCELADO', 1500.00, 5);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id)
VALUES (1, 4500.00, 1, 2);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id)
VALUES (1, 3200.00, 2, 3);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id)
VALUES (1, 2500.00, 3, 1);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id)
VALUES (1, 3800.00, 4, 4);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id)
VALUES (1, 1500.00, 5, 5);

INSERT INTO pagamento (data, status, tipo, valor, pedido_id) VALUES ('2023-10-01 10:35:00', 'PENDENTE', 'MULTIBANCO', 4500.00, 1);
INSERT INTO pagamento (data, status, tipo, valor, pedido_id) VALUES ('2023-10-02 14:20:00', 'APROVADO', 'MBWAY', 3200.00, 2);
INSERT INTO pagamento (data, status, tipo, valor, pedido_id) VALUES ('2023-10-03 09:05:00', 'APROVADO', 'CARTAO_CREDITO', 2500.00, 3);
INSERT INTO pagamento (data, status, tipo, valor, pedido_id) VALUES ('2023-10-04 16:50:00', 'APROVADO', 'CARTAO_DEBITO', 3800.00, 4);
INSERT INTO pagamento (data, status, tipo, valor, pedido_id) VALUES ('2023-10-05 11:25:00', 'RECUSADO', 'MBWAY', 1500.00, 5);