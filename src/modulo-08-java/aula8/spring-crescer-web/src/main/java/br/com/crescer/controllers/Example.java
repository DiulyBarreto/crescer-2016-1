package br.com.crescer.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
public class Example {

    @RequestMapping(value = "/")
    String toIndex(Model model) {
        model.addAttribute("name", "Diuly Any Moch Barreto");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
    public List<Pessoa> list(@RequestBody Pessoa p) {
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }
}