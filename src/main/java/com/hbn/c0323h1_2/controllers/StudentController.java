package com.hbn.c0323h1_2.controllers;

import com.hbn.c0323h1_2.models.Student;
import com.hbn.c0323h1_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//Đánh dấu đây là 1 controller(1 bean)
//Annotation Controller
@Controller
public class StudentController {
    //Sử dụng cơ chế DI(Dependency Injection): "tiêm" phụ thuộc để giảm sự phụ thuộc
    @Autowired
    private IStudentService studentService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/student")
    public String displayAllStudent(Model model) {
        List<Student> students = studentService.findAll();
        // 3 cách gửi đến view: Model(là 1 interface), ModelMap(1 class), vs ModelAndView(1 class)
        //1-model
        model.addAttribute("students", students);
        return "student/list";
    }

//    @GetMapping("/student")
//    public String displayAllStudent(ModelMap modelMap) {
//        List<Student> students = studentService.findAll();
//        //2-ModelMap
//        modelMap.put("students", students);
//        return "student/list";
//    }

//    @GetMapping("/student")
//    public ModelAndView displayAllStudent() {
//        //3-ModelAndView
//        return new ModelAndView("student/list", "students", studentService.findAll());
//    }

    @RequestMapping(value="student/create",method= RequestMethod.GET)
    public String viewCreate(){
        return "student/create";

    }

    @PostMapping("/student/create")
    public String newStudent(@RequestParam("name")String name,
                             @RequestParam("address")String address,
                             @RequestParam("point")Float point,
                             RedirectAttributes redirectAttributes){
        Student student = new Student(name,address,point);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Student created");
        return "redirect:/student";
    }

    @GetMapping("student/update/{id}")
    public String viewUpdate(@PathVariable("id")Long idStudent,Model model){
        Student student = studentService.findById(idStudent);
        model.addAttribute("student", student);
        return "student/update";
    }

    @PostMapping("student/update/{id}")
    public String update(@PathVariable("id")Long id,
                         @RequestParam("name")String name,
                         @RequestParam("address")String address,
                         @RequestParam("point")Float point,
                         RedirectAttributes redirectAttributes){
        Student student = new Student(name,address,point);
        studentService.updateById(id,student);
        redirectAttributes.addFlashAttribute("message", "Student updated");
        return "redirect:/student";
    }
}
