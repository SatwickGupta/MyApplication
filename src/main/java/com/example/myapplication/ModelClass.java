package com.example.myapplication;
public class ModelClass
{
    private int imageView1;
    private String textView;
    public ModelClass(int imageView1, String textView)
    {
       this.imageView1=imageView1;
       this.textView=textView;
    }
    public int getimageView()
    {
        return imageView1;
    }
    public String gettxtview()
    {
        return textView;
    }

}
