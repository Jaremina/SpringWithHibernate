package pl.akademiakodu.giflib.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademiakodu.giflib.model.Category;
import pl.akademiakodu.giflib.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.giflib.service.CategoryService;
import pl.akademiakodu.giflib.service.CategoryServiceImpl;
import pl.akademiakodu.giflib.service.GifService;
import pl.akademiakodu.giflib.web.FlashMessage;
import pl.akademiakodu.giflib.web.Status;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GifController {

    @Autowired
    private GifService gifService;
    @Autowired
    private CategoryService categoryService;

    // Home page - index of all GIFs
    @RequestMapping("/")
    public String listGifs(Model model) {
        List<Gif> gifs = gifService.findAll();

        model.addAttribute("gifs", gifs);
        return "gif/index";
    }

    // Single GIF page
    @RequestMapping("/gifs/{gifId}")
    public String gifDetails(@PathVariable Long gifId, Model model) {
        // TODO: Get gif whose id is gifId
        Gif gif = gifService.findByID(gifId);

        model.addAttribute("gif", gif);
        return "gif/details";
    }

    // GIF image data
    @RequestMapping("/gifs/{gifId}.gif")
    @ResponseBody
    public byte[] gifImage(@PathVariable Long gifId) {
        // TODO: Return image data as byte array of the GIF whose id is gifId
        return gifService.findByID(gifId).getBytes();
    }

    // Favorites - index of all GIFs marked favorite
    @RequestMapping("/favorites")
    public String favorites(Model model) {
        // TODO: Get list of all GIFs marked as favorite
        List<Gif> faves = new ArrayList<>();

        model.addAttribute("gifs",faves);
        model.addAttribute("username","Michal Makaruk"); // Static username
        return "gif/favorites";
    }

    // Upload a new GIF
    @RequestMapping(value = "/gifs", method = RequestMethod.POST)
    public String addGif(@RequestParam MultipartFile file, Gif gif, RedirectAttributes redirectAttributes) {
        // TODO: Upload new GIF if data is valid
        gifService.save(gif, file);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage(Status.SUCCESS, "gif added"));
        // TODO: Redirect browser to new GIF's detail view
        return "redirect:/gifs/" + gif.getId();
    }

    // Form for uploading a new GIF
    @RequestMapping("/upload")
    public String formNewGif(Model model) {
        // TODO: Add model attributes needed for new GIF upload form
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("gif", new Gif());

        return "gif/form";
    }

    // Form for editing an existing GIF
    @RequestMapping(value = "/gifs/{gifId}/edit")
    public String formEditGif(@PathVariable Long gifId, Model model) {
        // TODO: Add model attributes needed for edit form

        return "gif/form";
    }

    // Update an existing GIF
    @RequestMapping(value = "/gifs/{gifId}", method = RequestMethod.POST)
    public String updateGif() {
        // TODO: Update GIF if data is valid

        // TODO: Redirect browser to updated GIF's detail view
        return null;
    }

    // Delete an existing GIF
    @RequestMapping(value = "/gifs/{gifId}/delete", method = RequestMethod.POST)
    public String deleteGif(@PathVariable Long gifId) {
        // TODO: Delete the GIF whose id is gifId

        // TODO: Redirect to app root
        return null;
    }

    // Mark/unmark an existing GIF as a favorite
    @RequestMapping(value = "/gifs/{gifId}/favorite", method = RequestMethod.POST)
    public String toggleFavorite(@PathVariable Long gifId) {
        // TODO: With GIF whose id is gifId, toggle the favorite field

        // TODO: Redirect to GIF's detail view
        return null;
    }

    // Search results
    @RequestMapping("/search")
    public String searchResults(@RequestParam String q, Model model) {
        // TODO: Get list of GIFs whose description contains value specified by q
        List<Gif> gifs = new ArrayList<>();

        model.addAttribute("gifs",gifs);
        return "gif/index";
    }
}
