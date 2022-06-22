/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.HostelDTO;
import dto.ServiceTypeDTO;
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

    private final static String GET_A_SERVICETYPE = "SELECT * FROM dbo.[ServiceType] WHERE service_id = ?";
    private final static String GET_SERVICETYPE = "SELECT * FROM dbo.[ServiceType]";
    private static final String ADD_SERVICE = "INSERT INTO dbo.[ServiceType](service_name) VALUES(?)";

    private final static String GET_A_LATEST_SERVICEDETAIL = "SELECT TOP 1 * FROM dbo.[ServiceDetail] WHERE service_id = ? AND hostel_id = ? AND status = 'ACTIVE' ORDER BY detail_id DESC";
    private final static String GET_SERVICEDETAIL = "SELECT * FROM dbo.[ServiceDetail] WHERE hostel_id = ?";
    private static final String ADD_SERVICEDETAIL = "INSERT INTO dbo.[ServiceDetail](detail_name, calculation_unit, unit_price, updated_date, description, status, hostel_id, service_id) VALUES(?,?,?,?,?,?,?,?)";

    public List<ServiceTypeDTO> GetListService() throws SQLException {
        List<ServiceTypeDTO> list = new ArrayList<>();
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    ptm = conn.prepareStatement(GET_SERVICETYPE);
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        String service_id = rs.getString("service_id");
                        String service_name = rs.getString("service_name");
                        list.add(new ServiceTypeDTO(service_id,service_name));
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
        return list;
    }

    public List<ServiceDetailDTO> GetListServiceDetail(List<HostelDTO> HostelList) throws SQLException {
        List<ServiceDetailDTO> list = new ArrayList<>();
        for( HostelDTO i: HostelList){
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    ptm = conn.prepareStatement(GET_SERVICEDETAIL);
                    ptm.setString(1, i.getHostelID());
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        String detailname = rs.getString("detail_name");
                        String detail_id = rs.getString("detail_id");
                        String Calculation_Unit = rs.getString("calculation_unit");
                        Double unit_price = rs.getDouble("unit_price");
                        Date updated_date = rs.getDate("updated_date");
                        String description = rs.getString("description");
                        String status = rs.getString("status");
                        String service_id = rs.getString("service_id");
                        list.add(new ServiceDetailDTO(detail_id,detailname,Calculation_Unit,unit_price,updated_date,description,status, i.getHostelID(),service_id));
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
    public ServiceTypeDTO GetAService(String ServiceID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_A_SERVICETYPE);
                ptm.setString(1, ServiceID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String service_name = rs.getString("service_name");
                    return new ServiceTypeDTO(ServiceID,service_name);
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

    public ServiceDetailDTO GetLatestServiceDetail(String ServiceID, String HostelID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_A_LATEST_SERVICEDETAIL);
                ptm.setString(1, ServiceID);
                ptm.setString(2, HostelID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                        String detail_id = rs.getString("detail_id");
                        String detailname = rs.getString("detail_name");
                        String Calculation_Unit = rs.getString("calculation_unit");
                        Double unit_price = rs.getDouble("unit_price");
                        Date updated_date = rs.getDate("updated_date");
                        String status = rs.getString("status");
                        String description = rs.getString("description");
                    return new ServiceDetailDTO(detail_id,detailname,Calculation_Unit,unit_price,updated_date,description,status, HostelID,ServiceID);
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
    public boolean AddService(ServiceTypeDTO Service) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_SERVICE);
                ptm.setString(1, Service.getService_name());
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
                ptm.setString(1, s.getDetailname());
                ptm.setString(2, s.getCalUnit());
                ptm.setDouble(3, s.getUnit_price());
                ptm.setDate(4, s.getUpdated_date());
                ptm.setString(5, s.getDescription());
                ptm.setString(6, s.getHostelID());
                ptm.setString(7, s.getServiceID());
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
public static void main(String[] args) throws SQLException {
    List<ServiceDetailDTO> list = new ArrayList<>();
    ServiceDAO dao = new ServiceDAO();
    RoomDAO rdao = new RoomDAO();
    List<HostelDTO> ho = rdao.GetListHostel("1");
    List<ServiceDetailDTO> s = dao.GetListServiceDetail(ho);
    for(ServiceDetailDTO ss : s){
         System.out.println(ss.getDetailname());
    }
   

}


}
