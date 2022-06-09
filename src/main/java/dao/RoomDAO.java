/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.HostelDTO;
import dto.RoomDTO;
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
public class RoomDAO {
    private static final String GETHOSTEL = "SELECT * FROM dbo.[Hostel] where user_id = ?";
    private static final String GETROOM = "SELECT * FROM dbo.[Room] where hostel_id = ?";

    private static final String ADDROOM = "INSERT INTO dbo.[Room](hostel_id, room_number, roomsize, price, description, status) VALUES(?,?,?,?,?,?)";
    private static final String ADDHOSTEL = "INSERT INTO dbo.[Hostel](hostel_name, address, phone, user_id) VALUES(?,?,?,?)";

    private static final String UPDATEROOM = "UPDATE FROM dbo.[Room] SET hostel_id = ?, room_number = ?, roomsize = ?, price = ?, description = ?, status = ? where room_id = ?";
    private static final String UPDATEHOSTEL = "UPDATE FROM dbo.[Hostel] SET hostel_name = ?, address = ?, phone = ? where hostel_id =?"; 

    private static final String DELETEROOM = "DELETE dbo.[Room]  WHERE roomID = ?";
    private static final String DELETEHOSTEL = "UPDATE dbo.[Hostel] WHERE hostelID = ?";

    public List<HostelDTO> GetListHostel(String userID) throws SQLException {
        List<HostelDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETHOSTEL);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String HostelID = rs.getString("hostel_id");
                    String HostelName = rs.getString("hostel_name");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    list.add(new HostelDTO(HostelID,HostelName,address,phone,userID));
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
    public List<RoomDTO> GetListRoom(List<HostelDTO> HostelList) throws SQLException {
        List<RoomDTO> list = new ArrayList<>();

        for( HostelDTO i: HostelList){
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;

            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    ptm = conn.prepareStatement(GETROOM);
                    ptm.setString(1, i.getHostelID());
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        String RoomID = rs.getString("room_id");
                        String roomNumber = rs.getString("room_number");
                        String roomSize = rs.getString("roomsize");
                        Double price = rs.getDouble("price");
                        String description = rs.getString("description");
                        String status = rs.getString("status");
                        list.add(new RoomDTO(RoomID,i.getHostelID(),roomNumber,roomSize,price,description,status));
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
    public boolean DeleteHostel(String HostelID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETEHOSTEL);
                ptm.setString(1, HostelID);
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
    public boolean DeleteRoom(String RoomID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETEROOM);
                ptm.setString(1, RoomID);
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

    public boolean UpdateRoom(RoomDTO Room) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATEROOM);
                ptm.setString(1, Room.getHostelID());
                ptm.setString(2, Room.getRoomnumber());
                ptm.setString(3, Room.getRoomsize());
                ptm.setDouble(4, Room.getPrice());
                ptm.setString(5, Room.getDescription());
                ptm.setString(6, Room.getStatus());
                ptm.setString(7, Room.getRoomID());
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
    public boolean UpdateHostel(HostelDTO Hostel) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATEROOM);
                ptm.setString(1, Hostel.getHostelname());
                ptm.setString(2, Hostel.getAddress());
                ptm.setString(3, Hostel.getPhone());
                ptm.setString(4, Hostel.getPhone());
                ptm.setString(5, Hostel.getHostelID());
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
    public boolean AddRoom(RoomDTO room) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADDROOM);
                ptm.setString(1, room.getHostelID());
                ptm.setString(2, room.getRoomnumber());
                ptm.setString(3, room.getRoomsize());
                ptm.setDouble(4, room.getPrice());
                ptm.setString(5, room.getDescription());
                ptm.setString(6, room.getStatus());
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
    public boolean AddHostel(HostelDTO h) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADDHOSTEL);
                ptm.setString(1, h.getHostelname());
                ptm.setString(2, h.getAddress());
                ptm.setString(3, h.getPhone());
                ptm.setString(4, h.getUserID());
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
        List<RoomDTO> room = new ArrayList<>();
        RoomDAO dao = new RoomDAO();
        List<HostelDTO> list = dao.GetListHostel("1");
        for(HostelDTO o : list){
            room = dao.GetListRoom(list);
        }
        for(RoomDTO o : room){
            System.out.println(o);
        }
        
//        ProductSize list = dao.getProductAllSize("1");
////        for(Product o :list){
//            System.out.println(list);
////        }
        
    }
}