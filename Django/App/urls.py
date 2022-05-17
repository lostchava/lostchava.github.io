#imports from the current directory the views file
from . import views
from django.urls import path

urlpatterns = [
    #This is the Url that will bring us to our home page, referencing our home page.
    path('', views.PostList.as_view(), name="home"),
    path('AboutUs', views.AboutUsView.as_view(), name="aboutus"),
    path('AdoptionPage', views.AdoptionPageView.as_view(), name="adoptionpage"),
    path('ContactUs', views.ContactUsView.as_view(), name="contactus"),
    #can access the slug
    path('<slug:slug>/', views.PostList.as_view(), name="details"),
]