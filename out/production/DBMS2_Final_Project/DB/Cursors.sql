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