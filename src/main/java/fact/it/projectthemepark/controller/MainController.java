// Carlos Duarte r0841640 1ITF6
package fact.it.projectthemepark.controller;

import fact.it.projectthemepark.model.Attraction;
import fact.it.projectthemepark.model.Staff;
import fact.it.projectthemepark.model.ThemePark;
import fact.it.projectthemepark.model.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Controller
public class MainController {

    private ArrayList<Staff> staffMembers;
    private ArrayList<Visitor> visitors;
    private ArrayList<ThemePark> themeParks;

    @PostConstruct
    private void fillData() {
        staffMembers = fillStaffMembers();
        visitors = fillVisitors();
        themeParks = fillThemeParks();
    }

    @RequestMapping("/newvisitor")
    public String newvisitor(Model model) {
        model.addAttribute("themeparks", themeParks);
        return "1_newvisitor";
    }


    @RequestMapping("/newstaffmember")
    public String newstaffmember() {
        return "3_newstaffmember";
    }

    @RequestMapping("/submitnewvisitor")
    public String submitnewvisitor(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int year = Integer.parseInt(request.getParameter("year"));
        int park = Integer.parseInt(request.getParameter("park"));
        Visitor visitor = new Visitor(name, surname);
        visitor.setYearOfBirth(year);

        ThemePark themePark = themeParks.get(park);
        themePark.registerVisitor(visitor);
        visitors.add(visitor);
        model.addAttribute("visitor", visitor);
        model.addAttribute("themepark", themePark);
        return "2_showvisitor";
    }


    @RequestMapping("/newthemepark")
    String newpark() {
        return "7_newthemepark";
    }


    @RequestMapping("/submitpark")
    String submitpark(HttpServletRequest request, Model model) {
        String name = request.getParameter("parkName");
        ThemePark themePark = new ThemePark(name);
        themeParks.add(themePark);
        model.addAttribute("themepark", themePark);
        model.addAttribute("themeparks", themeParks);
        return "8_themeparklist";
    }

    @RequestMapping("/themeparklist")
    String themeparklist(Model model) {
        model.addAttribute("themeparks", themeParks);
        return "8_themeparklist";
    }

    @RequestMapping("/submitstaffmember")
    public String submitstaffmember(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate employedsince = LocalDate.parse(request.getParameter("date"), dtf);
        boolean student = (request.getParameter("student") != null);
        Staff staff = new Staff(name, surname);
        staff.setStartDate(employedsince);
        staff.setStudent(student);
        model.addAttribute("staff", staff);
        staffMembers.add(staff);
        return "4_newstaff";
    }

    @RequestMapping("/memberslist")
    public String memberslist(Model model) {
        model.addAttribute("staffmembers", staffMembers);
        return "5_stafflist";
    }

    @RequestMapping("/visitorslist")
    public String visitorslist(Model model) {
        model.addAttribute("visitors", visitors);
        return "6_ourvisitors";
    }


    @RequestMapping("/newattraction")
    public String newattraction(Model model) {
        model.addAttribute("themeparks", themeParks);
        model.addAttribute("staffmembers", staffMembers);
        return "9_newattraction";
    }


    @RequestMapping("/submitattraction")
    public String submitattraction(HttpServletRequest request, Model model) {
        String name = request.getParameter("attraction");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String photo = request.getParameter("photo");
        int parkindex = Integer.parseInt(request.getParameter("parksindex"));
        int staffindex = Integer.parseInt(request.getParameter("staffsindex"));

        if (parkindex < 0) {
            model.addAttribute("errormessge", "You didn't choose a theme park!");
            return "error";
        }
        if (staffindex < 0) {
            model.addAttribute("errormessge", "You didn't choose a staff member!");
            return "error";
        }

        ThemePark themePark = themeParks.get(parkindex);
        Staff staff = staffMembers.get(staffindex);

        Attraction attraction = new Attraction(name, duration);
        attraction.setPhoto(photo);
        attraction.setResponsible(staff);
        themePark.addAttraction(attraction);

        model.addAttribute("attraction", attraction);
        model.addAttribute("themepark", themePark);
        return "10_attractions";
    }


    @RequestMapping("/attractions")
    public String attractions(HttpServletRequest request, Model model) {
        int parkIndex = Integer.parseInt(request.getParameter("parkIndex"));
        ThemePark themePark = themeParks.get(parkIndex);
        model.addAttribute("image", "../img/noimage.jpg");
        model.addAttribute("themepark", themePark);
        return "10_attractions";
    }


    @RequestMapping("/searchname")
    public String searchname(HttpServletRequest request, Model model) {
        String attraction = request.getParameter("search");


        for (ThemePark park : themeParks) {
            if (park.searchAttractionByName(attraction) != null) {
                Attraction attraction1 = park.searchAttractionByName(attraction);
                model.addAttribute("attraction", attraction1);
                return "11_searchname";
            }
        }

        model.addAttribute("errormessge", "There is no attraction with name '" + attraction + "'");
        return "error";
    }


    private ArrayList<Staff> fillStaffMembers() {
        ArrayList<Staff> staffMembers = new ArrayList<>();
        Staff staff1 = new Staff("Johan", "Bertels");
        staff1.setStartDate(LocalDate.of(2002, 5, 1));
        Staff staff2 = new Staff("An", "Van Herck");
        staff2.setStartDate(LocalDate.of(2019, 3, 15));
        staff2.setStudent(true);
        Staff staff3 = new Staff("Bruno", "Coenen");
        staff3.setStartDate(LocalDate.of(1995, 1, 1));
        Staff staff4 = new Staff("Wout", "Dayaert");
        staff4.setStartDate(LocalDate.of(2002, 12, 15));
        Staff staff5 = new Staff("Louis", "Petit");
        staff5.setStartDate(LocalDate.of(2020, 8, 1));
        staff5.setStudent(true);
        Staff staff6 = new Staff("Jean", "Pinot");
        staff6.setStartDate(LocalDate.of(1999, 4, 1));
        Staff staff7 = new Staff("Ahmad", "Bezeri");
        staff7.setStartDate(LocalDate.of(2009, 5, 1));
        Staff staff8 = new Staff("Hans", "Volzky");
        staff8.setStartDate(LocalDate.of(2015, 6, 10));
        staff8.setStudent(true);
        Staff staff9 = new Staff("Joachim", "Henau");
        staff9.setStartDate(LocalDate.of(2007, 9, 18));
        staffMembers.add(staff1);
        staffMembers.add(staff2);
        staffMembers.add(staff3);
        staffMembers.add(staff4);
        staffMembers.add(staff5);
        staffMembers.add(staff6);
        staffMembers.add(staff7);
        staffMembers.add(staff8);
        staffMembers.add(staff9);
        return staffMembers;
    }

    private ArrayList<Visitor> fillVisitors() {
        ArrayList<Visitor> visitors = new ArrayList<>();
        Visitor visitor1 = new Visitor("Dominik", "Mioens");
        visitor1.setYearOfBirth(2001);
        Visitor visitor2 = new Visitor("Zion", "Noops");
        visitor2.setYearOfBirth(1996);
        Visitor visitor3 = new Visitor("Maria", "Bonetta");
        visitor3.setYearOfBirth(1998);
        Visitor visitor4 = new Visitor("Carlos", "Duarte");
        visitor4.setYearOfBirth(2000);
        visitors.add(visitor1);
        visitors.add(visitor2);
        visitors.add(visitor3);
        visitors.add(visitor4);
        visitors.get(0).addToWishList("De grote golf");
        visitors.get(0).addToWishList("Sky Scream");
        visitors.get(1).addToWishList("Piratenboot");
        visitors.get(1).addToWishList("Sky Scream");
        visitors.get(1).addToWishList("Halvar the ride");
        visitors.get(1).addToWishList("DreamCatcher");
        visitors.get(2).addToWishList("DinoSplash");
        visitors.get(3).addToWishList("SnakeTrail");
        visitors.get(3).addToWishList("Flying Dutch");
        return visitors;
    }

    private ArrayList<ThemePark> fillThemeParks() {
        ArrayList<ThemePark> themeparks = new ArrayList<>();
        ThemePark themepark1 = new ThemePark("Plopsaland");
        ThemePark themepark2 = new ThemePark("Plopsa Coo");
        ThemePark themepark3 = new ThemePark("Holiday Park");
        Attraction attraction1 = new Attraction("Anubis the Ride", 60);
        Attraction attraction2 = new Attraction("De grote golf", 180);
        Attraction attraction3 = new Attraction("Piratenboot", 150);
        Attraction attraction4 = new Attraction("SuperSplash", 258);
        Attraction attraction5 = new Attraction("Dansende fonteinen");
        Attraction attraction6 = new Attraction("Halvar the ride", 130);
        Attraction attraction7 = new Attraction("DinoSplash", 240);
        Attraction attraction8 = new Attraction("Bounty Tower", 180);
        Attraction attraction9 = new Attraction("Sky Scream", 50);
        attraction1.setPhoto("/img/anubis the ride.jpg");
        attraction2.setPhoto("/img/de grote golf.jpg");
        attraction3.setPhoto("/img/piratenboot.jpg");
        attraction4.setPhoto("/img/supersplash.jpg");
        attraction5.setPhoto("/img/dansende fonteinen.jpg");
        attraction6.setPhoto("/img/halvar the ride.jpg");
        attraction7.setPhoto("/img/dinosplash.jpg");
        attraction8.setPhoto("/img/bountytower.jpg");
        attraction9.setPhoto("/img/sky scream.jpg");
        attraction1.setResponsible(staffMembers.get(0));
        attraction2.setResponsible(staffMembers.get(1));
        attraction3.setResponsible(staffMembers.get(2));
        attraction4.setResponsible(staffMembers.get(3));
        attraction5.setResponsible(staffMembers.get(4));
        attraction6.setResponsible(staffMembers.get(5));
        attraction7.setResponsible(staffMembers.get(6));
        attraction8.setResponsible(staffMembers.get(7));
        attraction9.setResponsible(staffMembers.get(8));
        themepark1.addAttraction(attraction1);
        themepark1.addAttraction(attraction2);
        themepark1.addAttraction(attraction3);
        themepark1.addAttraction(attraction4);
        themepark2.addAttraction(attraction5);
        themepark2.addAttraction(attraction6);
        themepark3.addAttraction(attraction7);
        themepark3.addAttraction(attraction8);
        themepark3.addAttraction(attraction9);
        themeparks.add(themepark1);
        themeparks.add(themepark2);
        themeparks.add(themepark3);
        return themeparks;
    }
}

