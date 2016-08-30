--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: goods; Type: TABLE; Schema: public; Owner: shop
--

CREATE TABLE goods (
    id integer NOT NULL,
    description text,
    price double precision,
    price_cost double precision,
    img_path text,
    name text
);


ALTER TABLE goods OWNER TO shop;

--
-- Name: goods_id_seq; Type: SEQUENCE; Schema: public; Owner: shop
--

CREATE SEQUENCE goods_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE goods_id_seq OWNER TO shop;

--
-- Name: goods_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: shop
--

ALTER SEQUENCE goods_id_seq OWNED BY goods.id;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: shop
--

CREATE TABLE orders (
    orders_id integer NOT NULL,
    summ double precision,
    payment_type integer,
    delivery_type integer,
    delivery_adress text,
    name_client text,
    phone text,
    status integer
);


ALTER TABLE orders OWNER TO shop;

--
-- Name: orders_items; Type: TABLE; Schema: public; Owner: shop
--

CREATE TABLE orders_items (
    orders_items_id integer NOT NULL,
    orders_id integer,
    goods_id integer,
    qnt integer,
    price double precision,
    discount double precision,
    sum double precision
);


ALTER TABLE orders_items OWNER TO shop;

--
-- Name: orders_items_orders_items_id_seq; Type: SEQUENCE; Schema: public; Owner: shop
--

CREATE SEQUENCE orders_items_orders_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orders_items_orders_items_id_seq OWNER TO shop;

--
-- Name: orders_items_orders_items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: shop
--

ALTER SEQUENCE orders_items_orders_items_id_seq OWNED BY orders_items.orders_items_id;


--
-- Name: orders_orders_id_seq; Type: SEQUENCE; Schema: public; Owner: shop
--

CREATE SEQUENCE orders_orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orders_orders_id_seq OWNER TO shop;

--
-- Name: orders_orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: shop
--

ALTER SEQUENCE orders_orders_id_seq OWNED BY orders.orders_id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: shop
--

ALTER TABLE ONLY goods ALTER COLUMN id SET DEFAULT nextval('goods_id_seq'::regclass);


--
-- Name: orders_id; Type: DEFAULT; Schema: public; Owner: shop
--

ALTER TABLE ONLY orders ALTER COLUMN orders_id SET DEFAULT nextval('orders_orders_id_seq'::regclass);


--
-- Name: orders_items_id; Type: DEFAULT; Schema: public; Owner: shop
--

ALTER TABLE ONLY orders_items ALTER COLUMN orders_items_id SET DEFAULT nextval('orders_items_orders_items_id_seq'::regclass);


--
-- Data for Name: goods; Type: TABLE DATA; Schema: public; Owner: shop
--

COPY goods (id, description, price, price_cost, img_path, name) FROM stdin;
2	видеокамера2	85	70	2032.png	DS-2CD2032-I
3	видеокамера3	87	72	2112.png	DS-2CD2112-I
4	видеокамера4	95	80	2132.png	DS-2CD2132-I
5	2Мп Компактная IP-видеокамера день/ночь, фиксированный объектив 4мм (2.8мм, 4мм опция), 1/3 CMOS, видео с разрешением 1920х1080 25fps	104	72.7999999999999972	2420.png	DS-2CD2420F-I
6	супер видеокамера	147	100	2432.png	DS-2CD2432F-IW
1	суперкамера2	65	50	hik1.png	DS-2CD2012-I
\.


--
-- Name: goods_id_seq; Type: SEQUENCE SET; Schema: public; Owner: shop
--

SELECT pg_catalog.setval('goods_id_seq', 6, true);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: shop
--

COPY orders (orders_id, summ, payment_type, delivery_type, delivery_adress, name_client, phone, status) FROM stdin;
1	\N	\N	\N	\N	Alex	\N	\N
\.


--
-- Data for Name: orders_items; Type: TABLE DATA; Schema: public; Owner: shop
--

COPY orders_items (orders_items_id, orders_id, goods_id, qnt, price, discount, sum) FROM stdin;
\.


--
-- Name: orders_items_orders_items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: shop
--

SELECT pg_catalog.setval('orders_items_orders_items_id_seq', 1, false);


--
-- Name: orders_orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: shop
--

SELECT pg_catalog.setval('orders_orders_id_seq', 1, true);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

