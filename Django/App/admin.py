from django.contrib import admin

# Register your models here.
from .models import Post

#class that is used to organize post with a filter (used tuples to list attributes)
class PostAdmin(admin.ModelAdmin):
    list_display = ('title', 'slug', 'status')
    list_filter = ('status',)
    #search field looks for a title or content
    search_fields = ['title', 'content']




#brings over our classes to our admin page
admin.site.register(Post, PostAdmin)
# Register your models here.
