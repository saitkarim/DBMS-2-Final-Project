CREATE OR REPlACE PACKAGE PROC_PACKAGE
AS
PROCEDURE LAPT_INS(p_brand VARCHAR2, p_laptop_name VARCHAR2, p_size VARCHAR2, p_proc_type VARCHAR2 , p_graphics_card VARCHAR2, p_space VARCHAR2);
PROCEDURE LAPT_UPD_PRICE(p_laptop_name VARCHAR2,p_price VARCHAR2, p_old_price VARCHAR2);

end PROC_PACKAGE;

CREATE OR REPLACE PACKAGE BODY PROC_PACKAGE
AS 
PROCEDURE LAPT_INS(p_brand VARCHAR2, p_laptop_name VARCHAR2, p_size VARCHAR2, p_proc_type VARCHAR2 , p_graphics_card VARCHAR2, p_space VARCHAR2) IS
BEGIN
     INSERT INTO laptops(brand, laptop_name, display_size, processor_type, graphics_card, disk_space)
    VALUES(p_brand ,  p_laptop_name , p_size, p_proc_type ,p_graphics_card , p_space);
    COMMIT;
END LAPT_INS;
PROCEDURE LAPT_UPD_PRICE(p_laptop_name VARCHAR2,p_price VARCHAR2, p_old_price VARCHAR2) IS
BEGIN
    UPDATE laptops SET
    discount_price = p_price,
    old_price = p_old_price
    WHERE laptop_name = p_laptop_name;
    COMMIT;
END LAPT_UPD_PRICE; 
END;


CREATE OR REPLACE PACKAGE DYNAMIC_PACKAGE 
AS
PROCEDURE select_info(p_brand VARCHAR2);
PROCEDURE LAPT_DEL(p_laptop_name VARCHAR2);

END DYNAMIC_PACKAGE;


CREATE OR REPLACE PACKAGE BODY DYNAMIC_PACKAGE 
AS
PROCEDURE select_info(p_brand VARCHAR2) IS
BEGIN 
    EXECUTE IMMEDIATE 'SELECT * FROM laptops WHERE brand = '' ' || p_brand || '''';
END select_info;
PROCEDURE LAPT_DEL(p_laptop_name VARCHAR2) IS
BEGIN
   EXECUTE IMMEDIATE 'DELETE FROM laptops WHERE laptop_name = ''' || p_laptop_name || '''';
END LAPT_DEL;
END DYNAMIC_PACKAGE;

EXEC DYNAMIC_PACKAGE.select_info('HP'); 
EXEC DYNAMIC_PACKAGE.LAPT_DEL('Pavilion');

CREATE OR REPLACE PACKAGE cursors_package AS
    
END cursors_package;

CREATE OR REPLACE TRIGGER update_laptops_trigg
before update on laptops for each row
begin
    insert into updated_laptops (brand, laptop_name, display_size, processor_type, graphics_card, disk_space, updated_date)
    values(:new.brand, :new.laptop_name, :new.display_size, :new.processor_type, :new.graphics_card, :new.disk_space, sysdate);
end;

CREATE OR REPLACE TRIGGER new_laptops_trigg
before insert on laptops for each row
begin
    insert into new_laptops (brand, laptop_name, display_size, processor_type, graphics_card, disk_space, updated_date)
    values(:new.brand, :new.laptop_name, :new.display_size, :new.processor_type, :new.graphics_card, :new.disk_space, sysdate);
end;

CREATE OR REPLACE TRIGGER save_dropped_laptops_trigg
before delete on laptops for each row
begin
    insert into deleted_laptops (brand, laptop_name, display_size, processor_type, graphics_card, disk_space, DELETED_DATE)
    values(:old.brand, :old.laptop_name, :old.display_size, :old.processor_type, :old.graphics_card, :old.disk_space, sysdate);
end;

select count(*) from laptops;
SELECT DISTINCT brand FROM laptops;

------------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
CURSOR c1 IS SELECT * FROM laptops;
v_laptops_rec laptops%rowtype;
BEGIN
OPEN c1;
loop
FETCH c1 INTO v_laptops_rec;
EXIT WHEN c1%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('BRAND :' || v_laptops_rec.brand || '      LAPTOP NAME: ' || v_laptops_rec.laptop_name || '          DISK_SPACE:   ' || v_laptops_rec.disk_space);
END LOOP;
CLOSE c1;
END;
------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
CURSOR c2 IS SELECT * FROM laptops;
v_laptops_rec laptops%rowtype;
BEGIN
--DBMS_OUTPUT.PUT_LINE('BRAND' || '       ' || 'LAPTOP NAME' || '             ' || 'GRPHICS CARD');
OPEN c2;
loop
FETCH c2 INTO v_laptops_rec;
EXIT WHEN c2%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('BRAND :' || v_laptops_rec.brand || '      LAPTOP NAME: ' || v_laptops_rec.laptop_name || '          GRPHICS CARD:   ' 
|| v_laptops_rec.graphics_card);
END LOOP;
CLOSE c2;
END;


------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
CURSOR c3 IS SELECT * FROM laptops;
v_laptops_rec laptops%rowtype;
BEGIN
OPEN c3;
loop
FETCH c3 INTO v_laptops_rec;
EXIT WHEN c3%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('BRAND :' || v_laptops_rec.brand || '      LAPTOP NAME: ' || v_laptops_rec.laptop_name || '         PROCESSOR TYPE:   ' 
|| v_laptops_rec.processor_type);
END LOOP;
CLOSE c3;
END;
---------------------------------------------------------------------


SET SERVEROUTPUT ON;
DECLARE
CURSOR c4 IS SELECT * FROM laptop_feedback;
v_laptops_rec laptop_feedback%rowtype;
BEGIN
OPEN c4;
loop
FETCH c4 INTO v_laptops_rec;
EXIT WHEN c4%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('NAME :' || v_laptops_rec.name || '      EMAIL: ' || v_laptops_rec.email || '          SUBJECT:   ' ||
v_laptops_rec.subject || '  MESSAGE: ' || v_laptops_rec.message);
END LOOP;
CLOSE c4;
END;
-------------------------------------------------------------------------------









