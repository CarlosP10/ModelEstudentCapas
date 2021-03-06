PGDMP     %    2        	        x            MEstudiantes    11.5    12.0 M    a           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            b           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            c           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            d           1262    33352    MEstudiantes    DATABASE     �   CREATE DATABASE "MEstudiantes" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_El Salvador.1252' LC_CTYPE = 'Spanish_El Salvador.1252';
    DROP DATABASE "MEstudiantes";
                postgres    false            �            1259    33353    ciclo    TABLE     ]   CREATE TABLE public.ciclo (
    id_ciclo integer NOT NULL,
    ciclo character varying(5)
);
    DROP TABLE public.ciclo;
       public            postgres    false            �            1259    33356    ciclo_id_ciclo_seq    SEQUENCE     �   CREATE SEQUENCE public.ciclo_id_ciclo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.ciclo_id_ciclo_seq;
       public          postgres    false    196            e           0    0    ciclo_id_ciclo_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.ciclo_id_ciclo_seq OWNED BY public.ciclo.id_ciclo;
          public          postgres    false    197            �            1259    33358    cuenta    TABLE     �  CREATE TABLE public.cuenta (
    id_cuenta integer NOT NULL,
    nombre character varying(100),
    apellido character varying(100),
    fecha_nac date,
    edad integer,
    id_dpto integer,
    id_municipio integer,
    direccion character varying(150),
    estado boolean,
    nombre_usuario character varying(100),
    contrasenia character varying(50),
    id_tipo integer,
    sesion boolean,
    descripcion character varying(150)
);
    DROP TABLE public.cuenta;
       public            postgres    false            �            1259    33364    cuenta_id_cuenta_seq    SEQUENCE     �   CREATE SEQUENCE public.cuenta_id_cuenta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cuenta_id_cuenta_seq;
       public          postgres    false    198            f           0    0    cuenta_id_cuenta_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cuenta_id_cuenta_seq OWNED BY public.cuenta.id_cuenta;
          public          postgres    false    199            �            1259    33366    departamento    TABLE     f   CREATE TABLE public.departamento (
    id_dpto integer NOT NULL,
    nombre character varying(100)
);
     DROP TABLE public.departamento;
       public            postgres    false            �            1259    33369    departamento_id_dpto_seq    SEQUENCE     �   CREATE SEQUENCE public.departamento_id_dpto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.departamento_id_dpto_seq;
       public          postgres    false    200            g           0    0    departamento_id_dpto_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.departamento_id_dpto_seq OWNED BY public.departamento.id_dpto;
          public          postgres    false    201            �            1259    33371    escuelas    TABLE     �   CREATE TABLE public.escuelas (
    id_escuela integer NOT NULL,
    nombre character varying(150),
    estado boolean,
    descripcion character varying(200),
    id_municipio integer
);
    DROP TABLE public.escuelas;
       public            postgres    false            �            1259    33374    escuelas_id_escuela_seq    SEQUENCE     �   CREATE SEQUENCE public.escuelas_id_escuela_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.escuelas_id_escuela_seq;
       public          postgres    false    202            h           0    0    escuelas_id_escuela_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.escuelas_id_escuela_seq OWNED BY public.escuelas.id_escuela;
          public          postgres    false    203            �            1259    33376 
   expediente    TABLE     �  CREATE TABLE public.expediente (
    id_expediente integer NOT NULL,
    nombres character varying(100),
    apellidos character varying(100),
    fecha_nacimiento date,
    edad integer,
    direccion character varying(200),
    telefono_fijo integer,
    telefono_movil integer,
    id_escuela integer,
    nombre_padre character varying(250),
    nombre_madre character varying(250),
    id_municipio integer,
    carnet_min character varying(10)
);
    DROP TABLE public.expediente;
       public            postgres    false            �            1259    33382    expediente_id_expediente_seq    SEQUENCE     �   CREATE SEQUENCE public.expediente_id_expediente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.expediente_id_expediente_seq;
       public          postgres    false    204            i           0    0    expediente_id_expediente_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.expediente_id_expediente_seq OWNED BY public.expediente.id_expediente;
          public          postgres    false    205            �            1259    33384    materias    TABLE     �   CREATE TABLE public.materias (
    id_materia integer NOT NULL,
    nombre character varying(150),
    estado boolean,
    descripcion character varying(200)
);
    DROP TABLE public.materias;
       public            postgres    false            �            1259    33387    materias_id_materia_seq    SEQUENCE     �   CREATE SEQUENCE public.materias_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.materias_id_materia_seq;
       public          postgres    false    206            j           0    0    materias_id_materia_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.materias_id_materia_seq OWNED BY public.materias.id_materia;
          public          postgres    false    207            �            1259    33389    materiaxalumno    TABLE     �   CREATE TABLE public.materiaxalumno (
    id_materiaexp integer NOT NULL,
    id_expediente integer,
    id_ciclo integer,
    id_materia integer,
    anio integer,
    nota double precision
);
 "   DROP TABLE public.materiaxalumno;
       public            postgres    false            �            1259    33392     materiaxalumno_id_materiaexp_seq    SEQUENCE     �   CREATE SEQUENCE public.materiaxalumno_id_materiaexp_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.materiaxalumno_id_materiaexp_seq;
       public          postgres    false    208            k           0    0     materiaxalumno_id_materiaexp_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.materiaxalumno_id_materiaexp_seq OWNED BY public.materiaxalumno.id_materiaexp;
          public          postgres    false    209            �            1259    33394 	   municipio    TABLE     }   CREATE TABLE public.municipio (
    id_municipio integer NOT NULL,
    nombre character varying(100),
    id_dpto integer
);
    DROP TABLE public.municipio;
       public            postgres    false            �            1259    33397    municipio_id_municipio_seq    SEQUENCE     �   CREATE SEQUENCE public.municipio_id_municipio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.municipio_id_municipio_seq;
       public          postgres    false    210            l           0    0    municipio_id_municipio_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.municipio_id_municipio_seq OWNED BY public.municipio.id_municipio;
          public          postgres    false    211            �            1259    33399    tipo_usuario    TABLE     f   CREATE TABLE public.tipo_usuario (
    id_tipo integer NOT NULL,
    nombre character varying(100)
);
     DROP TABLE public.tipo_usuario;
       public            postgres    false            �            1259    33402    tipo_usuario_id_tipo_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_usuario_id_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tipo_usuario_id_tipo_seq;
       public          postgres    false    212            m           0    0    tipo_usuario_id_tipo_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.tipo_usuario_id_tipo_seq OWNED BY public.tipo_usuario.id_tipo;
          public          postgres    false    213            �
           2604    33404    ciclo id_ciclo    DEFAULT     p   ALTER TABLE ONLY public.ciclo ALTER COLUMN id_ciclo SET DEFAULT nextval('public.ciclo_id_ciclo_seq'::regclass);
 =   ALTER TABLE public.ciclo ALTER COLUMN id_ciclo DROP DEFAULT;
       public          postgres    false    197    196            �
           2604    33405    cuenta id_cuenta    DEFAULT     t   ALTER TABLE ONLY public.cuenta ALTER COLUMN id_cuenta SET DEFAULT nextval('public.cuenta_id_cuenta_seq'::regclass);
 ?   ALTER TABLE public.cuenta ALTER COLUMN id_cuenta DROP DEFAULT;
       public          postgres    false    199    198            �
           2604    33406    departamento id_dpto    DEFAULT     |   ALTER TABLE ONLY public.departamento ALTER COLUMN id_dpto SET DEFAULT nextval('public.departamento_id_dpto_seq'::regclass);
 C   ALTER TABLE public.departamento ALTER COLUMN id_dpto DROP DEFAULT;
       public          postgres    false    201    200            �
           2604    33407    escuelas id_escuela    DEFAULT     z   ALTER TABLE ONLY public.escuelas ALTER COLUMN id_escuela SET DEFAULT nextval('public.escuelas_id_escuela_seq'::regclass);
 B   ALTER TABLE public.escuelas ALTER COLUMN id_escuela DROP DEFAULT;
       public          postgres    false    203    202            �
           2604    33408    expediente id_expediente    DEFAULT     �   ALTER TABLE ONLY public.expediente ALTER COLUMN id_expediente SET DEFAULT nextval('public.expediente_id_expediente_seq'::regclass);
 G   ALTER TABLE public.expediente ALTER COLUMN id_expediente DROP DEFAULT;
       public          postgres    false    205    204            �
           2604    33409    materias id_materia    DEFAULT     z   ALTER TABLE ONLY public.materias ALTER COLUMN id_materia SET DEFAULT nextval('public.materias_id_materia_seq'::regclass);
 B   ALTER TABLE public.materias ALTER COLUMN id_materia DROP DEFAULT;
       public          postgres    false    207    206            �
           2604    33410    materiaxalumno id_materiaexp    DEFAULT     �   ALTER TABLE ONLY public.materiaxalumno ALTER COLUMN id_materiaexp SET DEFAULT nextval('public.materiaxalumno_id_materiaexp_seq'::regclass);
 K   ALTER TABLE public.materiaxalumno ALTER COLUMN id_materiaexp DROP DEFAULT;
       public          postgres    false    209    208            �
           2604    33411    municipio id_municipio    DEFAULT     �   ALTER TABLE ONLY public.municipio ALTER COLUMN id_municipio SET DEFAULT nextval('public.municipio_id_municipio_seq'::regclass);
 E   ALTER TABLE public.municipio ALTER COLUMN id_municipio DROP DEFAULT;
       public          postgres    false    211    210            �
           2604    33412    tipo_usuario id_tipo    DEFAULT     |   ALTER TABLE ONLY public.tipo_usuario ALTER COLUMN id_tipo SET DEFAULT nextval('public.tipo_usuario_id_tipo_seq'::regclass);
 C   ALTER TABLE public.tipo_usuario ALTER COLUMN id_tipo DROP DEFAULT;
       public          postgres    false    213    212            M          0    33353    ciclo 
   TABLE DATA           0   COPY public.ciclo (id_ciclo, ciclo) FROM stdin;
    public          postgres    false    196   �[       O          0    33358    cuenta 
   TABLE DATA           �   COPY public.cuenta (id_cuenta, nombre, apellido, fecha_nac, edad, id_dpto, id_municipio, direccion, estado, nombre_usuario, contrasenia, id_tipo, sesion, descripcion) FROM stdin;
    public          postgres    false    198   \       Q          0    33366    departamento 
   TABLE DATA           7   COPY public.departamento (id_dpto, nombre) FROM stdin;
    public          postgres    false    200   �]       S          0    33371    escuelas 
   TABLE DATA           Y   COPY public.escuelas (id_escuela, nombre, estado, descripcion, id_municipio) FROM stdin;
    public          postgres    false    202   1^       U          0    33376 
   expediente 
   TABLE DATA           �   COPY public.expediente (id_expediente, nombres, apellidos, fecha_nacimiento, edad, direccion, telefono_fijo, telefono_movil, id_escuela, nombre_padre, nombre_madre, id_municipio, carnet_min) FROM stdin;
    public          postgres    false    204   �_       W          0    33384    materias 
   TABLE DATA           K   COPY public.materias (id_materia, nombre, estado, descripcion) FROM stdin;
    public          postgres    false    206   Mc       Y          0    33389    materiaxalumno 
   TABLE DATA           h   COPY public.materiaxalumno (id_materiaexp, id_expediente, id_ciclo, id_materia, anio, nota) FROM stdin;
    public          postgres    false    208   Hd       [          0    33394 	   municipio 
   TABLE DATA           B   COPY public.municipio (id_municipio, nombre, id_dpto) FROM stdin;
    public          postgres    false    210    f       ]          0    33399    tipo_usuario 
   TABLE DATA           7   COPY public.tipo_usuario (id_tipo, nombre) FROM stdin;
    public          postgres    false    212   Xo       n           0    0    ciclo_id_ciclo_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.ciclo_id_ciclo_seq', 1, false);
          public          postgres    false    197            o           0    0    cuenta_id_cuenta_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.cuenta_id_cuenta_seq', 13, true);
          public          postgres    false    199            p           0    0    departamento_id_dpto_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.departamento_id_dpto_seq', 1, false);
          public          postgres    false    201            q           0    0    escuelas_id_escuela_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.escuelas_id_escuela_seq', 25, true);
          public          postgres    false    203            r           0    0    expediente_id_expediente_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.expediente_id_expediente_seq', 15, true);
          public          postgres    false    205            s           0    0    materias_id_materia_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.materias_id_materia_seq', 16, true);
          public          postgres    false    207            t           0    0     materiaxalumno_id_materiaexp_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.materiaxalumno_id_materiaexp_seq', 4, true);
          public          postgres    false    209            u           0    0    municipio_id_municipio_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.municipio_id_municipio_seq', 1, false);
          public          postgres    false    211            v           0    0    tipo_usuario_id_tipo_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.tipo_usuario_id_tipo_seq', 1, false);
          public          postgres    false    213            �
           2606    33414    ciclo ciclo_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.ciclo
    ADD CONSTRAINT ciclo_pkey PRIMARY KEY (id_ciclo);
 :   ALTER TABLE ONLY public.ciclo DROP CONSTRAINT ciclo_pkey;
       public            postgres    false    196            �
           2606    33416    cuenta cuenta_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id_cuenta);
 <   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_pkey;
       public            postgres    false    198            �
           2606    33418    departamento departamento_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id_dpto);
 H   ALTER TABLE ONLY public.departamento DROP CONSTRAINT departamento_pkey;
       public            postgres    false    200            �
           2606    33420    escuelas escuelas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.escuelas
    ADD CONSTRAINT escuelas_pkey PRIMARY KEY (id_escuela);
 @   ALTER TABLE ONLY public.escuelas DROP CONSTRAINT escuelas_pkey;
       public            postgres    false    202            �
           2606    33422    expediente expediente_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.expediente
    ADD CONSTRAINT expediente_pkey PRIMARY KEY (id_expediente);
 D   ALTER TABLE ONLY public.expediente DROP CONSTRAINT expediente_pkey;
       public            postgres    false    204            �
           2606    33424    materias materias_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.materias
    ADD CONSTRAINT materias_pkey PRIMARY KEY (id_materia);
 @   ALTER TABLE ONLY public.materias DROP CONSTRAINT materias_pkey;
       public            postgres    false    206            �
           2606    33426 "   materiaxalumno materiaxalumno_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.materiaxalumno
    ADD CONSTRAINT materiaxalumno_pkey PRIMARY KEY (id_materiaexp);
 L   ALTER TABLE ONLY public.materiaxalumno DROP CONSTRAINT materiaxalumno_pkey;
       public            postgres    false    208            �
           2606    33428    municipio municipio_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT municipio_pkey PRIMARY KEY (id_municipio);
 B   ALTER TABLE ONLY public.municipio DROP CONSTRAINT municipio_pkey;
       public            postgres    false    210            �
           2606    33430    tipo_usuario tipo_usuario_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT tipo_usuario_pkey PRIMARY KEY (id_tipo);
 H   ALTER TABLE ONLY public.tipo_usuario DROP CONSTRAINT tipo_usuario_pkey;
       public            postgres    false    212            �
           2606    33431    cuenta fk_cuentadptoid    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cuentadptoid FOREIGN KEY (id_dpto) REFERENCES public.departamento(id_dpto);
 @   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT fk_cuentadptoid;
       public          postgres    false    198    200    2749            �
           2606    33436    cuenta fk_cuentamunid    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cuentamunid FOREIGN KEY (id_municipio) REFERENCES public.municipio(id_municipio);
 ?   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT fk_cuentamunid;
       public          postgres    false    198    210    2759            �
           2606    33441    cuenta fk_cuentatipoid    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cuentatipoid FOREIGN KEY (id_tipo) REFERENCES public.tipo_usuario(id_tipo);
 @   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT fk_cuentatipoid;
       public          postgres    false    198    2761    212            �
           2606    33446    municipio fk_dptoid    FK CONSTRAINT     ~   ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT fk_dptoid FOREIGN KEY (id_dpto) REFERENCES public.departamento(id_dpto);
 =   ALTER TABLE ONLY public.municipio DROP CONSTRAINT fk_dptoid;
       public          postgres    false    210    2749    200            �
           2606    33451    materiaxalumno fk_expcicloid    FK CONSTRAINT     �   ALTER TABLE ONLY public.materiaxalumno
    ADD CONSTRAINT fk_expcicloid FOREIGN KEY (id_ciclo) REFERENCES public.ciclo(id_ciclo);
 F   ALTER TABLE ONLY public.materiaxalumno DROP CONSTRAINT fk_expcicloid;
       public          postgres    false    208    2745    196            �
           2606    33456    expediente fk_expeescuelaid    FK CONSTRAINT     �   ALTER TABLE ONLY public.expediente
    ADD CONSTRAINT fk_expeescuelaid FOREIGN KEY (id_escuela) REFERENCES public.escuelas(id_escuela);
 E   ALTER TABLE ONLY public.expediente DROP CONSTRAINT fk_expeescuelaid;
       public          postgres    false    202    2751    204            �
           2606    33461    materiaxalumno fk_expexpid    FK CONSTRAINT     �   ALTER TABLE ONLY public.materiaxalumno
    ADD CONSTRAINT fk_expexpid FOREIGN KEY (id_expediente) REFERENCES public.expediente(id_expediente);
 D   ALTER TABLE ONLY public.materiaxalumno DROP CONSTRAINT fk_expexpid;
       public          postgres    false    2753    204    208            �
           2606    33466    materiaxalumno fk_expmatid    FK CONSTRAINT     �   ALTER TABLE ONLY public.materiaxalumno
    ADD CONSTRAINT fk_expmatid FOREIGN KEY (id_materia) REFERENCES public.materias(id_materia);
 D   ALTER TABLE ONLY public.materiaxalumno DROP CONSTRAINT fk_expmatid;
       public          postgres    false    208    2755    206            �
           2606    33471    expediente fk_idmunicipio    FK CONSTRAINT     �   ALTER TABLE ONLY public.expediente
    ADD CONSTRAINT fk_idmunicipio FOREIGN KEY (id_municipio) REFERENCES public.municipio(id_municipio);
 C   ALTER TABLE ONLY public.expediente DROP CONSTRAINT fk_idmunicipio;
       public          postgres    false    210    204    2759            �
           2606    33476    escuelas fk_idmunicipio    FK CONSTRAINT     �   ALTER TABLE ONLY public.escuelas
    ADD CONSTRAINT fk_idmunicipio FOREIGN KEY (id_municipio) REFERENCES public.municipio(id_municipio);
 A   ALTER TABLE ONLY public.escuelas DROP CONSTRAINT fk_idmunicipio;
       public          postgres    false    210    202    2759            M      x�3�40�2�40�2�40����� ��      O   U  x����N� ���S� j
U�.��`�9�U�i�^����W��h7I�R��_O@Up��S�[�κj:�8�j>`v5�y
-J��L��^}���1ᣓl��Y�/d:I֕l<�' �AP��]��]���vI6�()XJ}�Ri&�AW���B�2]�_"5��$����3�D�A1]���IkΪ�)S��KLp��dóg�/�#�Rp�i�E���}.���Ə`Dn��q��rM}�;s��x(�Z��O����
O��w>�:�-B	ϑ��ew�֐��zz��˂�Gj8[|���F��j�Z;���]z�{bS��k���!�`%�l      Q   �   x��M
�0�����F��,n
bW݌?�^�I��6=B��XMv�0��(�����N��8$7gT�F�z>P����~v��H�����T�otf�3�޶p:/�c�+�h�~aY�#��^6�RT[��{�Rif,1gqWN��5����i�	?w��vb<�      S   �  x����N�0�����H�=�EB�T�^��7�ֵ�خH�~�M��6B"K3_����K��6
a���MA6�	�Ob���ص��g	+M�%��T��9�sxF�}m3�
���Qj�⎼����x��;3��o��Y@V;��B=�^٫�<՝͙L�.��+Xk{�'�4�r��&�Q^���oh�i�EB.��G������b��Y���*�|���{�[w�b��֎\���g������BJ�B�q�J�%4n���*ϑ4�x����]�����(��T��|+�3ʊ/%�
S�G��0X�'2bB��R��梸��v��'bQ\}��<[tyKg�!@)��2�ƥ�(/N��R)���0eyV��'����<�֙���'&\�aNф��,`�N>`r��T�¢�=��_}Q.��7!��!�      U   M  x�e�Mr�6�׭S�L���VM�qYN�vM6�IDDD	HJ�\(��"�lu�4(���B_�~� �1����Ο�SN�
Z�P��i|ב�]��\hYjХ(���������{�`SoB��a��ߕ���? =�M������(y�G��J0�@SS*�0�nJ���ܴm��/p�6X��ƍ�0��Y7bJr�cFO�qJ#��k+Ak�4�2�����4`��;�4���_�[�R�M�&��i�u�k�-���m=yH��W{:�`]b	kx���������U��u��0��n��x�Ng��S���ZE9�6��~���K뽫ۅj������ݡv8�+��,C[Z*���<M}=�����Y����a�������FQ�ލ-��������r�A���ua��ktr)��\Se,�^b��5�\j�dX��{�~Ą$��GB�
R�u�w����ɣF&h���%Ϥ��>����q!�dW7+�q)'�ޏ#0k��.(PA���7>��'��K�\�ڍ�L)�����S��;?T��u8���u�.���+��Α:�]�>�=���A�i��7����+��m#4q���]<�0\34 ��龬��]�b
�0��w�)K��!\��!�q�%�9�,��/��&�� ��#<��U7*�֚�O���4ߨj��@.%w��~�)���*eҀx1�E3�*������o19��'��C��㺄�]�eg�i�o�X�Ωg���W�k<9��e��>���"q���Ǽ�5���,VLe�!�SL�����d	�T
kE	�4BX��ђ�CqI[�r���j�7��y2      W   �   x�}��j�0���S�	i�n�6(v�EM�TԱR[tO?%������?��/�c(`��jk!�RB�Zp�0�I�K��51��[ecl�=��}?�D>ƀx���>j�$L}H:�ʸ�7)~�پ��p/�]���ϰ��ܪ8��+���ÔZ���I�sO�-�N�`�.���ȡ��kM�G6-�l`���Ğ�;&�93]%�B�6[(�Hc�!d�i��d5'������s�      Y   �  x���[� �o��{���c���L���8"�z
8`�8)��a��y�`�j�v�����-CK�z��d5�z0�JP��R=k��`hl#[S"�ў%R��ZဣM�.dd�1��1;�}�s�垬�>���W
��W>[�\j�s���E���E@���5P{Z��7��{{�m�U�,������=�a�j�H�ޢ��C�����y�e�V�m���Jy`��A00�� �c����ا��0�v����<&��Ko'�q`���40�-��E���20h��5Ի��_Γ�5�ۼw����&��O�]1�1�0���ا^c�cb+C��皈a����!>�����i�tz{3�0��PÐ�65����a�Q'�=�0��(��>F1�1�a��QC>o������b�0�a��L�=�'��\?�      [   (	  x�mXMs�8=ÿ���eK$EQ::v��N4���L��`.�P@�5ֿ�1��r�Ul_w��ݛ�54��uC�:{�z����F�'��/��5~�ꬳ߂��7���5�YWv��I&9�t�(��:�3OaiI��ˠ�V�Y�T���nLE;Lսn�^7�m+�ܚf��Y�t3��8o�}�����w�<�#&��z�Ux�ߙz~���Nsu��S���d[�q�k:��NR����
W]�\�.�3k�-�'t\&C*I�;�j�	��[�j|ݑ4S���e'��y�t���T��FפHYqou�Y,N�um;o��2Rw_�EY�;���Bb׶��A9f��K��w�
�`����6�D�UZ���d��_�&,L�: l�=S�����+?�G�j'�.O��m��>�3���N��\[rD��َ|�8�	ܒ�����_ǵe�����F';WC9�ʫV?b����CΘ�%nE��g.�f%�1����c�)�]E1Sg�Y"y�H��\�3��MҘ|d��'�Pd�;�yӲ������<9�9�,�o��m�޷�n6�)_��5�UM5@@1��+NM�R�<$���+�0m�y����U�A0�HT�^6V�6���5��C�F��eh�hd�AH��h$}�l({a���ǳ��֯�xRMF1X�kl�H�[ݻz���@�#��HC��s���2b��C�au~2�PA�MMe)�@�b��<%զ��6,��޺��r�Ю��m ��bk;�P�n\�v'��B6W��帏D@갖E���GW���r�D��|0k١�?�¹������H��_�IS!��r$�;�4
��K� {?��O�|��PU��cZ�-�}�F�y��W��8;���p�[��̎�A�"��ا!�A��S��j6nPF������նza<1� "F�����qʺ�ZK�*Wu����N�X����&f�D* ��l�	#�rYfe�@�w	�v�����*�=����X�$����5%!���7hH�7HG�Q�\�.����Ar�z��©�v���PǦi���y�*k��"O�nڛ>S_�J#�,��~�ݵ�_��F'�	���T����W��#�d,x� P�+�:T��D�w��� �_�3t��ݑ�����7��!3�΁�_�gw".�KW?�}Y:�H����n��+tL7`���/���Z�..���^�JLAg=��v5D�R��R������ֻ����Q�.9m�
t^*�Άu��=Y����ptM�!!g�j��$�՟���� 2���p"Lr�Sx-�K
�}Do@�ҷY0p-kf���TOcɧ�E��a8�'�(s*��o�$ߧ@����5�$�o���?"�>׏�Kh����	�����!%D̙;�n�Њ���@��[{t���F�H�G-1,�a0�v,!G03�r�9�i2 �?�������]��!��pK%�iM�A�� }�Fz�e�+�|t(j3h�PNF�j<b�0U�q��ϖOGw��"-�&'y�땈c�=�X@l�/h\O�$���	/#�1���/N���k�n�`��tO�%]vUle��;jZ�>lX�(o��|��x�2?bס�Oy���`o�J�W�ϏH����Z6��be9d��]8Ϛ)��J݈U�a4�9K�x�Q���3п	�B�P$�<ID��b@�����ɐZ��{���k������B ��u��i����v��:��
����3�������u��E���l��RԽ"���F���pn9�-�E�W�E��5�t��U��(B�r�����+�~ӹ��X��$��.��Q`ġpO �8��o�[��>�Q!�̾�� l�:�%2��B
�a5�v����R]�8�߂F�y��p�y�k���T&�w�H#$U}�)��f�n}%��y�c�q6�t������M�D%�O�3�	�] �C����搆�^;����H���j�1�`xu|Fr82�mNY��kdH��!K��+	�΍}�M�&����u"�Q	��7ͼ����=BI%L�~e��������Ӄ��A"7���k���t�?p�!0�p܆��eM����O�AM�d#�x��oUY�h�����ʃ���_����;��]X�I�}�7���@m��k�cp�o<f� f��	���c}�VNs>c��GM�"1���o'c�9�����u%�ȡ�S����� ��/�"��1'�����t(U��Y�������!<��#���6D��za��
�ÿ���$�D���IP�s0T<��1@<���r��Q,7F2�Y��������ޙm      ]   '   x�3�tL����,.)JL�/�2�t��/J���b���� �9
�     