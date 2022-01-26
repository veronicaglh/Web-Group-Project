package com.Group11.Mekinaye;
//import java.util.Arrays;
//mport java.util.List;
//mport java.util.stream.Collectors;
//import java.util.stream.Stream;

//import com.Group11.Mekinaye.RatingType.Type;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.support.SessionStatus;
@Controller
@RequestMapping("/rating/current")
@RequiredArgsConstructor
public class RatingController {
    private final RatingRepository repository;
  /*  @ModelAttribute
    public void RatingMapper(Model model){
        List<Rating>ratings=Arrays.asList(
            new Rating("vego",Type.very_good),
            new Rating("good",Type.good),
            new Rating("rBAD",Type.bad));
            Type[] u =Rating.Type.values();
            for (Type type: u){
                model.addAttribute(type.toString().toLowerCase(), filterByType(ratings,type));}      
   
    }*/

    @GetMapping
    public String rating(Model model ) {
        Rating ratingA=new Rating() ;
        model.addAttribute("rating",ratingA);
        return "Rating";
    }  
    /*private Iterable<Rating>filterByType(
        List<Rating>rating,Type type)
    {
        
        return rating
        .stream()
        .filter(x->x.getType().equals(type))
        .collect(Collectors.toList());
    }*/
 
    
    @PostMapping
   public String returnToHomePage(Rating rating)
{
    this.repository.save(rating);
    return "redirect:/";
}}

