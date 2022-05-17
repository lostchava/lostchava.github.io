from django.db import models

# Create your models here.
from django.contrib.auth.models import User
# Create your models here.

#Status variable used a tuple to give 0: for draft posts and 1: for published posts 
STATUS = ((0, "Draft"), (1, "Published"))

#This is a class that uses models.Model as the main parameter. Inside this will be fields or collumns for text
class Post(models.Model):
    title = models.CharField(max_length=200, unique=True)

    #SlugField is used for storing basically storing URL paths after a particular URL.
    slug = models.SlugField(max_length=200, unique=True)

    #Text Field
    content = models.TextField()
    #What the defaul status of the post will be (draft)
    status = models.IntegerField(choices=STATUS, default=0)


    def __str__(self):
        return self.title