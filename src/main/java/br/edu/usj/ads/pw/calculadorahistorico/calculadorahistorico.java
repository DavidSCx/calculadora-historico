package br.edu.usj.ads.pw.calculadorahistorico;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class calculadorahistorico {

    //List <String> historico = new ArrayList<>();
  @Autowired
  OperacaoRepository historico;

    @PostMapping(value="calcular")
    public ModelAndView postCalcular(@RequestParam String operando1,
     @RequestParam String operando2, @RequestParam String operador){
    //converter para double
    Double operando1Double = Double.valueOf(operando1);
    Double operando2Double = Double.valueOf(operando2);
    //operar

    // verificar qual operacao eh
    Double resultado = null;
    if ("+".equals(operador)) {
        resultado = operando1Double + operando2Double;
    }
    //colocar a operacao no formato
    String operacaoString = operando1 + " " + operador + " " + operando2 + " = " + resultado; 

    operacao operacao = new operacao();
    operacao.setDescricao(operacaoString);
    //salvar no historico
    historico.save(operacao);

   // historico.add(operacao); ArrayList
    //instanciar template
    ModelAndView modelAndView = new ModelAndView("index");
   //criar lista com as operacoes vindas do repository

   List<operacao> lista = historico.findAll();

    //aplicar resultado da operacao no template
    modelAndView.addObject("resultado", resultado);
    modelAndView.addObject("historico", lista);
    //retornar

    return modelAndView; 

}
}