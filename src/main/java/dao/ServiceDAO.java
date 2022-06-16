/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ContractDTO;
import dto.HostelDTO;
import dto.RoomDTO;
import dto.ServiceDTO;
import dto.ServiceDetailDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author avillX
 */
public class ServiceDAO {

    private final static String GET_A_SERVICE = "SELECT * FROM dbo.[Service] WHERE service_id = ?";
    private final static String GET_SERVICE = "SELECT * FROM dbo.[Service] WHERE hostel_id = ?";
    private static final String ADD_SERVICE = "INSERT INTO dbo.[Service](service_name, hostel_id) VALUES(?,?)";

    private final static String GET_A_LATEST_SERVICEDETAIL = "SELECT TOP 1 * FROM dbo.[ServiceDetail] WHERE service_id = ? ORDER BY history_id DESC";
    private final static String GET_SERVICEDETAIL = "SELECT * FROM dbo.[ServiceDetail] WHERE service_id = ?";
    private static final String ADD_SERVICEDETAIL = "INSERT INTO dbo.[ServiceDetail](calculation_unit, unit_price, updated_date, description, service_id) VALUES(?,?,?,?,?)";

    public List<ServiceDTO> GetListService(List<HostelDTO> HostelList) throws SQLException {
        List<ServiceDTO> list = new ArrayList<>();
        for( HostelDTO i: HostelList){
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    ptm = conn.prepareStatement(GET_SERVICE);
                    ptm.setString(1, i.getHostelID());
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        String service_id = rs.getString("service_id");
                        String service_name = rs.getString("service_name");
                        list.add(new ServiceDTO(service_id,service_name,i.getHostelID()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ptm != null) {
                    ptm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }
        return list;
    }
    public List<ServiceDetailDTO> GetListServiceDetail(List<ServiceDTO> DetailList) throws SQLException {
        List<ServiceDetailDTO> list = new ArrayList<>();
        for( ServiceDTO i: DetailList){
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    ptm = conn.prepareStatement(GET_SERVICEDETAIL);
                    ptm.setString(1, i.getServiceID());
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        String history_id = rs.getString("history_id");
                        String Calculation_Unit = rs.getString("calculation_unit");
                        Double unit_price = rs.getDouble("unit_price");
                        Date updated_date = rs.getDate("due_date");
                        String description = rs.getString("description");
                        list.add(new ServiceDetailDTO(history_id,Calculation_Unit,unit_price,updated_date,description,i.getServiceID()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ptm != null) {
                    ptm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }
        return list;
    }
    public ServiceDTO GetAService(String ServiceID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_A_SERVICE);
                ptm.setString(1, ServiceID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String hostel_id = rs.getString("hostel_id");
                    String service_name = rs.getString("service_name");
                    return new ServiceDTO(ServiceID,hostel_id,service_name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null; 
    }

    public ServiceDetailDTO GetLatestServiceDetail(String ServiceID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_A_SERVICE);
                ptm.setString(1, ServiceID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                        String history_id = rs.getString("history_id");
                        String Calculation_Unit = rs.getString("calculation_unit");
                        Double unit_price = rs.getDouble("unit_price");
                        Date updated_date = rs.getDate("due_date");
                        String description = rs.getString("description");
                    return new ServiceDetailDTO(history_id,Calculation_Unit,unit_price,updated_date,description,ServiceID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null; 
    }
    public boolean AddService(ServiceDTO Service) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_SERVICE);
                ptm.setString(1, Service.getService_name());
                ptm.setString(2, Service.getHostelID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    public boolean AddServiceDetail(ServiceDetailDTO s) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_SERVICEDETAIL);
                ptm.setString(1, s.getCalUnit());
                ptm.setDouble(2, s.getUnit_price());
                ptm.setDate(3, s.getUpdated_date());
                ptm.setString(4, s.getDescription());
                ptm.setString(5, s.getServiceID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }


}
