package com.example.myapplication;

import android.net.Uri;

public class NewsItem {
    private class Source{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    Source source;
    private String author;
    private String title;
    private String description;
    private Uri url;
    private Uri urlToImage;
    private String publishedAt;
    private String content;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getUrl() {
        return url;
    }

    public void setUrl(Uri url) {
        this.url = url;
    }

    public Uri getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(Uri urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


/*
{
-"source": {
"id": "engadget",
"name": "Engadget"
},
"author": "Steve Dent",
"title": "Hulu update brings picture-in-picture back to the iPhone",
"description": "Hulu has added picture-in-picture support back into iOS, making it possible for iPhone and iPad users to keep an eye on programs while browsing other apps, MacRumors has reported. Support for the feature had been enabled on iOS 14 when it first launched, but …",
"url": "https://www.engadget.com/hulus-latest-iphone-update-adds-picture-in-picture-111601970.html",
"urlToImage": "https://s.yimg.com/uu/api/res/1.2/Uoo7khUYnunUTc624GHD0w--~B/aD0zMjY2O3c9NDkwMTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-images/2019-04/5024c490-605e-11e9-bb73-fbf784aba74b.cf.jpg",
"publishedAt": "2021-03-03T11:16:01Z",
"content": "Hulu has added picture-in-picture support back into iOS, making it possible for iPhone and iPad users to keep an eye on programs while browsing other apps, MacRumors has reported. Support for the fea… [+680 chars]"
},
 */