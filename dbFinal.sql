PGDMP     )                    z            SpritesRiver    14.1 (Debian 14.1-1.pgdg110+1)    14.1 3    <           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            =           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            >           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16987    SpritesRiver    DATABASE     b   CREATE DATABASE "SpritesRiver" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';
    DROP DATABASE "SpritesRiver";
                postgres    false            ?            1259    17097    commento_seq    SEQUENCE     u   CREATE SEQUENCE public.commento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.commento_seq;
       public          postgres    false            ?            1259    16988    commento    TABLE     ?   CREATE TABLE public.commento (
    id_commento integer DEFAULT nextval('public.commento_seq'::regclass) NOT NULL,
    data date NOT NULL,
    stringcommento character varying NOT NULL,
    utente character varying
);
    DROP TABLE public.commento;
       public         heap    postgres    false    216            ?            1259    17066    gioco    TABLE       CREATE TABLE public.gioco (
    id_gioco integer NOT NULL,
    titolo character varying NOT NULL,
    genere character varying,
    piattaforma character varying,
    descrizione character varying,
    percorsoimmagine character varying,
    datarilascio character varying NOT NULL
);
    DROP TABLE public.gioco;
       public         heap    postgres    false            ?            1259    17107 	   gioco_seq    SEQUENCE     r   CREATE SEQUENCE public.gioco_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.gioco_seq;
       public          postgres    false    214            @           0    0 	   gioco_seq    SEQUENCE OWNED BY     @   ALTER SEQUENCE public.gioco_seq OWNED BY public.gioco.id_gioco;
          public          postgres    false    218            ?            1259    25313    relaz_commento_sprite    TABLE     ?   CREATE TABLE public.relaz_commento_sprite (
    id_relaz_commento_sprite integer DEFAULT nextval('public.commento_seq'::regclass) NOT NULL,
    id_commento integer NOT NULL,
    id_sprite integer NOT NULL
);
 )   DROP TABLE public.relaz_commento_sprite;
       public         heap    postgres    false    216            ?            1259    17071    relaz_gioco_sprite    TABLE     ?   CREATE TABLE public.relaz_gioco_sprite (
    id_relaz_gioco_sprite integer DEFAULT nextval('public.commento_seq'::regclass) NOT NULL,
    id_sprite integer NOT NULL,
    id_gioco integer NOT NULL
);
 &   DROP TABLE public.relaz_gioco_sprite;
       public         heap    postgres    false    216            ?            1259    17001    relaz_utente_commento    TABLE     ?   CREATE TABLE public.relaz_utente_commento (
    pk_relaz_utente_commento integer DEFAULT nextval('public.commento_seq'::regclass) NOT NULL,
    id_utente integer NOT NULL,
    id_commento integer NOT NULL
);
 )   DROP TABLE public.relaz_utente_commento;
       public         heap    postgres    false    216            ?            1259    17004    relaz_utente_sprite    TABLE     ?   CREATE TABLE public.relaz_utente_sprite (
    id_relaz_utente_sprite integer DEFAULT nextval('public.commento_seq'::regclass) NOT NULL,
    id_utente integer NOT NULL,
    id_sprite integer NOT NULL
);
 '   DROP TABLE public.relaz_utente_sprite;
       public         heap    postgres    false    216            ?            1259    17007    sprite    TABLE     ?   CREATE TABLE public.sprite (
    id_sprite integer NOT NULL,
    nomepersonaggio character varying NOT NULL,
    spritesheet character varying,
    immaginepersonaggio character varying
);
    DROP TABLE public.sprite;
       public         heap    postgres    false            ?            1259    17110 
   sprite_seq    SEQUENCE     s   CREATE SEQUENCE public.sprite_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.sprite_seq;
       public          postgres    false    212            A           0    0 
   sprite_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.sprite_seq OWNED BY public.sprite.id_sprite;
          public          postgres    false    219            ?            1259    17012    utente    TABLE     ?   CREATE TABLE public.utente (
    id_utente integer NOT NULL,
    email character varying,
    username character varying,
    password character varying,
    moderatore boolean
);
    DROP TABLE public.utente;
       public         heap    postgres    false            ?            1259    17104 
   utente_seq    SEQUENCE     s   CREATE SEQUENCE public.utente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.utente_seq;
       public          postgres    false    213            B           0    0 
   utente_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.utente_seq OWNED BY public.utente.id_utente;
          public          postgres    false    217            ?           2604    17108    gioco id_gioco    DEFAULT     g   ALTER TABLE ONLY public.gioco ALTER COLUMN id_gioco SET DEFAULT nextval('public.gioco_seq'::regclass);
 =   ALTER TABLE public.gioco ALTER COLUMN id_gioco DROP DEFAULT;
       public          postgres    false    218    214            ?           2604    17111    sprite id_sprite    DEFAULT     j   ALTER TABLE ONLY public.sprite ALTER COLUMN id_sprite SET DEFAULT nextval('public.sprite_seq'::regclass);
 ?   ALTER TABLE public.sprite ALTER COLUMN id_sprite DROP DEFAULT;
       public          postgres    false    219    212            ?           2604    17109    utente id_utente    DEFAULT     j   ALTER TABLE ONLY public.utente ALTER COLUMN id_utente SET DEFAULT nextval('public.utente_seq'::regclass);
 ?   ALTER TABLE public.utente ALTER COLUMN id_utente DROP DEFAULT;
       public          postgres    false    217    213            .          0    16988    commento 
   TABLE DATA           M   COPY public.commento (id_commento, data, stringcommento, utente) FROM stdin;
    public          postgres    false    209   s:       3          0    17066    gioco 
   TABLE DATA           s   COPY public.gioco (id_gioco, titolo, genere, piattaforma, descrizione, percorsoimmagine, datarilascio) FROM stdin;
    public          postgres    false    214   ;       9          0    25313    relaz_commento_sprite 
   TABLE DATA           a   COPY public.relaz_commento_sprite (id_relaz_commento_sprite, id_commento, id_sprite) FROM stdin;
    public          postgres    false    220   JH       4          0    17071    relaz_gioco_sprite 
   TABLE DATA           X   COPY public.relaz_gioco_sprite (id_relaz_gioco_sprite, id_sprite, id_gioco) FROM stdin;
    public          postgres    false    215   ?H       /          0    17001    relaz_utente_commento 
   TABLE DATA           a   COPY public.relaz_utente_commento (pk_relaz_utente_commento, id_utente, id_commento) FROM stdin;
    public          postgres    false    210   ?H       0          0    17004    relaz_utente_sprite 
   TABLE DATA           [   COPY public.relaz_utente_sprite (id_relaz_utente_sprite, id_utente, id_sprite) FROM stdin;
    public          postgres    false    211   !I       1          0    17007    sprite 
   TABLE DATA           ^   COPY public.sprite (id_sprite, nomepersonaggio, spritesheet, immaginepersonaggio) FROM stdin;
    public          postgres    false    212   mI       2          0    17012    utente 
   TABLE DATA           R   COPY public.utente (id_utente, email, username, password, moderatore) FROM stdin;
    public          postgres    false    213   K       C           0    0    commento_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.commento_seq', 90, true);
          public          postgres    false    216            D           0    0 	   gioco_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.gioco_seq', 53, true);
          public          postgres    false    218            E           0    0 
   sprite_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.sprite_seq', 32, true);
          public          postgres    false    219            F           0    0 
   utente_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.utente_seq', 14, true);
          public          postgres    false    217            ?           2606    17018    commento Commento_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.commento
    ADD CONSTRAINT "Commento_pkey" PRIMARY KEY (id_commento);
 B   ALTER TABLE ONLY public.commento DROP CONSTRAINT "Commento_pkey";
       public            postgres    false    209            ?           2606    17102    utente Email&Username_Skey 
   CONSTRAINT     |   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT "Email&Username_Skey" UNIQUE (email, username) INCLUDE (email, username);
 F   ALTER TABLE ONLY public.utente DROP CONSTRAINT "Email&Username_Skey";
       public            postgres    false    213    213            ?           2606    17075    gioco Gioco_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.gioco
    ADD CONSTRAINT "Gioco_pkey" PRIMARY KEY (id_gioco);
 <   ALTER TABLE ONLY public.gioco DROP CONSTRAINT "Gioco_pkey";
       public            postgres    false    214            ?           2606    17077 *   relaz_gioco_sprite Relaz_Gioco_Sprite_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public.relaz_gioco_sprite
    ADD CONSTRAINT "Relaz_Gioco_Sprite_pkey" PRIMARY KEY (id_relaz_gioco_sprite);
 V   ALTER TABLE ONLY public.relaz_gioco_sprite DROP CONSTRAINT "Relaz_Gioco_Sprite_pkey";
       public            postgres    false    215            ?           2606    17024 0   relaz_utente_commento Relaz_Utente_Commento_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.relaz_utente_commento
    ADD CONSTRAINT "Relaz_Utente_Commento_pkey" PRIMARY KEY (pk_relaz_utente_commento);
 \   ALTER TABLE ONLY public.relaz_utente_commento DROP CONSTRAINT "Relaz_Utente_Commento_pkey";
       public            postgres    false    210            ?           2606    17026 ,   relaz_utente_sprite Relaz_Utente_Sprite_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.relaz_utente_sprite
    ADD CONSTRAINT "Relaz_Utente_Sprite_pkey" PRIMARY KEY (id_relaz_utente_sprite);
 X   ALTER TABLE ONLY public.relaz_utente_sprite DROP CONSTRAINT "Relaz_Utente_Sprite_pkey";
       public            postgres    false    211            ?           2606    17028    sprite Sprite_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.sprite
    ADD CONSTRAINT "Sprite_pkey" PRIMARY KEY (id_sprite);
 >   ALTER TABLE ONLY public.sprite DROP CONSTRAINT "Sprite_pkey";
       public            postgres    false    212            ?           2606    17030    utente Utente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT "Utente_pkey" PRIMARY KEY (id_utente);
 >   ALTER TABLE ONLY public.utente DROP CONSTRAINT "Utente_pkey";
       public            postgres    false    213            ?           2606    17126    sprite personaggio 
   CONSTRAINT     z   ALTER TABLE ONLY public.sprite
    ADD CONSTRAINT personaggio UNIQUE (immaginepersonaggio) INCLUDE (immaginepersonaggio);
 <   ALTER TABLE ONLY public.sprite DROP CONSTRAINT personaggio;
       public            postgres    false    212            ?           2606    25317 0   relaz_commento_sprite relaz_commento_sprite_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.relaz_commento_sprite
    ADD CONSTRAINT relaz_commento_sprite_pkey PRIMARY KEY (id_relaz_commento_sprite);
 Z   ALTER TABLE ONLY public.relaz_commento_sprite DROP CONSTRAINT relaz_commento_sprite_pkey;
       public            postgres    false    220            ?           2606    17124    sprite sheet 
   CONSTRAINT     y   ALTER TABLE ONLY public.sprite
    ADD CONSTRAINT sheet UNIQUE (spritesheet) INCLUDE (spritesheet, immaginepersonaggio);
 6   ALTER TABLE ONLY public.sprite DROP CONSTRAINT sheet;
       public            postgres    false    212    212            ?           2606    17120    gioco unique 
   CONSTRAINT     x   ALTER TABLE ONLY public.gioco
    ADD CONSTRAINT "unique" UNIQUE (titolo, datarilascio) INCLUDE (titolo, datarilascio);
 8   ALTER TABLE ONLY public.gioco DROP CONSTRAINT "unique";
       public            postgres    false    214    214            ?           1259    17031    fki_R    INDEX     Y   CREATE INDEX "fki_R" ON public.relaz_utente_sprite USING btree (id_relaz_utente_sprite);
    DROP INDEX public."fki_R";
       public            postgres    false    211            ?           1259    17032    fki_fkey_Commento    INDEX     i   CREATE INDEX "fki_fkey_Commento" ON public.relaz_utente_commento USING btree (pk_relaz_utente_commento);
 '   DROP INDEX public."fki_fkey_Commento";
       public            postgres    false    210            ?           1259    17078    fki_fkey_Gioco    INDEX     `   CREATE INDEX "fki_fkey_Gioco" ON public.relaz_gioco_sprite USING btree (id_relaz_gioco_sprite);
 $   DROP INDEX public."fki_fkey_Gioco";
       public            postgres    false    215            ?           1259    17034    fki_fkey_Sprite    INDEX     c   CREATE INDEX "fki_fkey_Sprite" ON public.relaz_utente_sprite USING btree (id_relaz_utente_sprite);
 %   DROP INDEX public."fki_fkey_Sprite";
       public            postgres    false    211            ?           1259    17035    fki_fkey_Utente    INDEX     g   CREATE INDEX "fki_fkey_Utente" ON public.relaz_utente_commento USING btree (pk_relaz_utente_commento);
 %   DROP INDEX public."fki_fkey_Utente";
       public            postgres    false    210            .   ?   x?E?A
?0????)?Tb??.ŕ?	??`?t ͔?U????????g????v-??$D?l8+?b??Y?轗
қKQ?7k???kVs?詂?????Y?вK?E???????Up??;M? ?\xoD? ud-      3   3  x??Y[o?~?~???P??-???Ȏ`[QC?H??p9$??????a"?Y|I[?@??/zR????H?"i???/ac????9?K-%9Ƀi^fg??;???hm??pl?}32?@١??????R?)=T?U~??y??LLZxg???nc'V#??U?2????????0j???"??W?{?w6?jp?G?????U?(??d??٦21%??t`Ufܳ/????????~l®	?b???Ŷ???<?????a9?j?ӑ?????>?zRј|NW????z??ju%?<'??7X?F?i????8???>??f?>1N`???5C`kfSq??i?t?ٜ????'?X????GF?eP?Z????i?iv?pt|?????D?!???ჅOFe?!?"?^?F???@???P=ʨ|???8??gl??&??l?"?x?h?yRW???%??K?'?N('!??=7??5r?x`R?h@?@ǈ 15?????*??㗛?'X?J?8???9B??N??Y?i!pQ?挳?Qv42?( ?4=֊\???S?=2????Չ?)ߣ(z?(zvؓ??-??z?^a{??WE+KG???fg??Y^?,?wL'??5?cku?$?g?-適???̦???g6}:;?z6??l:???C?
?U׳???W??߄?|q?`??s??Q?Y???ut|?q?!|?KMk?q???=??#d?Hw?Uw?L???+-uG'6??z?2??<??Pp??&0??>??х+Ԕg???UiWX&?ƙD?ɀB?i??!GI???c?<???w(*<?(?9#?r?(????6Q??l????{*??Q??p)1=?W???`Cd-L??WZ"E????l=?ז?k˝ͥ??? ?F ???H=?i?V?z??qw??!?R=??!???	P??l?sJ?8??qs??l???\`><???S?????/?)'gFsT??ʴ?s-?6??c????u(GК???3?iB?o?W?Φ??$a"Q?znԂ?-??C07??sw@?OJH ????#<?Ȑ?b9????h84\?L???y!~0?3)s??}w'@???n?#?ކ??G?rs?f2׎IB?5D?{Ӥ?@,'???m?gi???FWG"r⨈I}@??-???\p???`?F?ѳ??r}??e???n??<??Gihhh]?ϥ?1-H?+?!!?y?n????J??IfKq??a	ǖ?^??y????w?	\?JG;a?? ??Jx^ȋ???,=R???C???5?f`R?nm???dvٰ?HSVСAµc*	?M?&??#w??{?]??#?)?]??	?G?>aܓ@?Qٴ??q???t?h?|p:*!<??? ????/nk0??"F?
T??$?-u_??h	?$S<???H?j&Ҋ?" *??ʩ[?,?7?@???Qd??B?
?????????Nj?W?l??N??٪?1??W??ۍ???=??N?V{?/??????-?
????l?+y??l?????????O??_??kUu_<͞???E?<~??Xz????]ٴ???,????9Q?5q??WpC?|?S?C??/s#?8nl0?+o
9M??4?CL????p?z+e?	a?E?c?	Zx????Wu?Sq*?? ?D????h`5U??4?G???Q??r??A/XP?Y???{?;?=?kNP?(?-?;?Xc
c?^0܎?FGci4Lq??a???0R?J
k
?8???~?HӞfU??'2'??DT?i
?.6??D?u?? ?֕:h????'?ф7?n???4Rc:matq?w????Pֽ??m??u?Y[[???acc??^^Y]Z_i܆??i#%dݣ$???g4?vi4.XLr??5\dGyh???Yu%?BX?a!0???o<ܽڬ?\m???H??t???o?@?B??t????#{?Օ?'????_??_Φ???|6?3޼?^~???????߾?????/_???ڮ??P?j[̅??B?A^??KJ`RLe2??*藠J0??*?$sOe??y??m?V?h?1?W?"?p?_?+e?A?0????w??2#??,??? ?8?)](I?QY?|V^?-H?X??????y/???f?`??n"????? S??ܔ????R6ZcV??l??[wX&F?`
??o??+?I2@٘??????=̹??Α?gi??Y?Ψg?A?D?ə????l?!?c*{1?`??k?b??vg?y?	???kL??\??y?]k?l???(?:&??E?љ??d?W?鏂M??????ŤR۰?U??ۺ_?#ח۫?+???Ն?ê?????oY\?-???)?%????Ciџ?3?{>,?88z??;????Q??l??6?0m??<-$??F4c???˝??'?Q????0??/7jT??0?5?????n|?? ????I	??N$9:??1?[???(e??D??R
2?ꔑ??k?7~??K7????!t??y?H?F6gε???uS????cR?#Ix?Y4?O?X???C????.q~?vJp???꟰Z???7??Q ????j??)xlx?.!??D?ַS??x2???9P????\kՖ=$5֧?Ue61???猓{?2?asG?wQ:]?CEU7???s??p?"?@?X_..h?,]??^(???H4??0"?5?և?oa???M??? ??t.{9If?
???LdvP?)k|???Ik?`?@U????V????&?֊????>ǭe?mb??T$sГ?	-l??/*v?\ލ?F???u????fҩ???P?]?C?????~ ?\k	??>@W????A̖??Uނ?͊Ntݚ?z?{?*?ߔ?o?ĳ?Czx?ܟ:"?o?????}?l?a???yo???Ls???zD???m???㻍??Zos??oy1??k?z?u???~?Ϳ???1ϛQ}:3?z????2V)?0Zy?,???,T|??I9$?7?a???????d?z?,
P??qys8o?<WO??j????2?{n???a@:? 	??E34??%??BA?IygYȽw?,o0?ɝX>ݢ~?????ɗ=a?bg8m;&?`%l
????V????r?????AV7?B5?'$?]e,N%|??*\?????w??5?C?!??/??O?`Ͼ???9?Ƶ??|)J??>6??/??L?G??I???h???_^???MbϷ<???&_?????5?6	?????(]?u	j??o??????r????߸!\?U???rgL|H??? ? |?o*?{96'#???D?~?Z?????#E??a\?????v}??j??喵?@@?̓????+]???:K?Ng?????????Ug      9   3   x?5??  ?w;?Qwq?9&??r!6,??#dt???D?%Y???3H^??      4   ?   x????0??=L?@?.??6zJ??y?<??d??|ǅ(h?Zt????*???v      /   5   x?-ʱ  ?99????߁@l?s?E,?d?E:Se7W?n$	??      0   <   x????0???XL`ɶ?^?A?7 ???aq?1?I?P?(5}????^??????>?#E      1   ?  x?u?Ms?0??ɯ???????Ar?2?e?tX?^????㨛X?????q6?R_,???H?y?h?	?`?ߟ&?A?oQ?;k??ڳ)y?UY]?b?"?؃?ۗuV?g?.????????}????q2)???q????v?v?9Ϧ???l7lGN?۹x??$,?N)?M?3????Ye?ʦ*Y[眵???Z??4ۏ?2S???grg?? ?q,"??w????~?$?zU??k?{??\X?m2?Cz;\??
R?"ۆ(z???2?lfHz???5#?9?vfk?_g????^;?~O?'0\$8???2???懟0??s??'?wdi??U^nsb???8?XYph?v/G9????Sm?V?qwЎ1b??z??Q??J30?5???P$C???ĵ???4M??^?      2   ?   x?M??n?0  ?s??-?z??n̙]
V
?Y??o?3???@?N??c?1??Ru? L?L??h??ȧVP?&Ț?:?oA??(\?y6?	?JK?]Os9??O?2?t?ﹺ??p?]??+???O??s?͎V?O????<l????m??F??.???o?`?Z??W????0???g|??]c??x??"}?lY?/?iXj???v?ed????4?,V"     