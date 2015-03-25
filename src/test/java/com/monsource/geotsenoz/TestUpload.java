package com.monsource.geotsenoz;

import com.monsource.geotsenoz.data.dao.HudagDao;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import com.monsource.geotsenoz.data.entity.HudagEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nasanjargal on 12/23/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context-db.xml"})
@TransactionConfiguration(defaultRollback = false)
public class TestUpload {

    @Autowired
    SessionFactory factory;

    @Test
    @Transactional
    public void upload() throws Exception {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("/home/nasanjargal/Desktop/BOHHUDAGORUULAH.xls"));
        Sheet sheet = workbook.getSheetAt(0);

//        AimagEntity aimagEntity = new AimagEntity();
//        aimagEntity.setAimagId(22);

        List<Integer> dugaars = new ArrayList<>();


        Session session = factory.getCurrentSession();

        Query query = session.createQuery("FROM HudagEntity WHERE dugaar = :dugaar AND aimag.aimagId = :aimagId AND torol = 'BO'");

        for (Row rows : sheet) {

            if (rows.getRowNum() == 0) continue;

            int dugaar = 0;

            Cell dugaarCell = rows.getCell(0);
            if (dugaarCell != null) {
                dugaarCell.setCellType(Cell.CELL_TYPE_STRING);
                if (!dugaarCell.getStringCellValue().equals(""))
                    dugaar = Integer.parseInt(dugaarCell.getStringCellValue());
            }

            query.setInteger("dugaar", dugaar);
            query.setInteger("aimagId", 22);

            List<HudagEntity> list = query.list();

            if (list.size() > 0) {
                HudagEntity hudagEntity = list.get(0);

                if (list.size() > 1) dugaars.add(hudagEntity.getDugaar());

                Cell tag = rows.getCell(1);
                if (tag != null) {
                    tag.setCellType(Cell.CELL_TYPE_STRING);
                    if (!tag.getStringCellValue().equals(""))
                        hudagEntity.setTagTmdgt(Float.parseFloat(tag.getStringCellValue()));
                }

                Cell gazar = rows.getCell(2);
                if (gazar != null) {
                    gazar.setCellType(Cell.CELL_TYPE_STRING);
                    if (!gazar.getStringCellValue().equals(""))
                        hudagEntity.setGazTemdegt(Float.parseFloat(gazar.getStringCellValue()));
                }

                Cell erool = rows.getCell(3);
                if (erool != null) {
                    erool.setCellType(Cell.CELL_TYPE_STRING);
                    if (!erool.getStringCellValue().equals(""))
                        hudagEntity.setHudagErool(Float.parseFloat(erool.getStringCellValue()));
                }

                Cell hovil = rows.getCell(4);
                if (hovil != null) {
                    hovil.setCellType(Cell.CELL_TYPE_STRING);
                    if (!hovil.getStringCellValue().equals(""))
                        hudagEntity.setHooloiErool(Float.parseFloat(hovil.getStringCellValue()));
                }

                Cell tailbar = rows.getCell(5);
                if (tailbar != null) {
                    tailbar.setCellType(Cell.CELL_TYPE_STRING);
                    if (!tailbar.getStringCellValue().equals(""))
                        hudagEntity.setTailbar(tailbar.getStringCellValue());
                }

                session.merge(hudagEntity);
            }

            /*try {

                HudagEntity hudagEntity = (HudagEntity) query.uniqueResult();

            }catch (NonUniqueResultException e) {
                HudagEntity o = (HudagEntity) query.list().get(0);
                System.out.println(o.getDugaar());
            }*/
            /*Cell tag = rows.getCell(1);
            if (tag != null) {
                tag.setCellType(Cell.CELL_TYPE_STRING);
                if (!tag.getStringCellValue().equals(""))
                    hudagEntity.setTagTmdgt(Float.parseFloat(tag.getStringCellValue()));
            }

            Cell gazar = rows.getCell(2);
            if (gazar != null) {
                gazar.setCellType(Cell.CELL_TYPE_STRING);
                if (!gazar.getStringCellValue().equals(""))
                    hudagEntity.setGazTemdegt(Float.parseFloat(gazar.getStringCellValue()));
            }

            Cell erool = rows.getCell(3);
            if (erool != null) {
                erool.setCellType(Cell.CELL_TYPE_STRING);
                if (!erool.getStringCellValue().equals(""))
                    hudagEntity.setHudagErool(Float.parseFloat(erool.getStringCellValue()));
            }

            Cell hovil = rows.getCell(4);
            if (hovil != null) {
                hovil.setCellType(Cell.CELL_TYPE_STRING);
                if (!hovil.getStringCellValue().equals(""))
                    hudagEntity.setHooloiErool(Float.parseFloat(hovil.getStringCellValue()));
            }

            Cell tailbar = rows.getCell(5);
            if (tailbar != null) {
                tailbar.setCellType(Cell.CELL_TYPE_STRING);
                if (!tailbar.getStringCellValue().equals(""))
                    hudagEntity.setTailbar(tailbar.getStringCellValue());
            }

//            hudagEntity.setOk(false);
//            hudagEntity.setAimag(aimagEntity);


            hudagDao.merge(hudagEntity);*/

        }

        for (Integer dugaar : dugaars) {
            System.out.println("dugaar = " + dugaar);
        }
    }


}
