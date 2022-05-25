from django.shortcuts import render
#importing our class in models
from .models import Post
#importing a built-in feature (generic)
from django.views import generic
# Create your views here. 
# Django maps the views to urls in order to render corresponding template, gets the page you're looking for.

#This class helps us organize the homepage 
class PostList(generic.ListView):
    queryset = Post.objects.filter(status=1)
    #home page
    template_name = 'index.html'
# links to our web page
class AboutUsView(generic.ListView):
    queryset = Post.objects.filter(status=1)
    template_name = 'aboutUs.html'
class AdoptionPageView(generic.ListView):
    queryset = Post.objects.filter(status=1)
    template_name = 'adoptionPage.html'
class ContactUsView(generic.ListView):
    queryset = Post.objects.filter(status=1)
    template_name = 'contactUs.html'