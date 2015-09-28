package com.android.phuston.imgor.models;

import com.android.phuston.imgor.Image;

import java.util.HashMap;
import java.util.Map;


public class Item {

    private String kind;
    private String title;
    private String htmlTitle;
    private String link;
    private String displayLink;
    private String snippet;
    private String htmlSnippet;
    private String mime;
    private String fileFormat;
    private Image image;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     *
     * @param kind
     * The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The htmlTitle
     */
    public String getHtmlTitle() {
        return htmlTitle;
    }

    /**
     *
     * @param htmlTitle
     * The htmlTitle
     */
    public void setHtmlTitle(String htmlTitle) {
        this.htmlTitle = htmlTitle;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The displayLink
     */
    public String getDisplayLink() {
        return displayLink;
    }

    /**
     *
     * @param displayLink
     * The displayLink
     */
    public void setDisplayLink(String displayLink) {
        this.displayLink = displayLink;
    }

    /**
     *
     * @return
     * The snippet
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     *
     * @param snippet
     * The snippet
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     *
     * @return
     * The htmlSnippet
     */
    public String getHtmlSnippet() {
        return htmlSnippet;
    }

    /**
     *
     * @param htmlSnippet
     * The htmlSnippet
     */
    public void setHtmlSnippet(String htmlSnippet) {
        this.htmlSnippet = htmlSnippet;
    }

    /**
     *
     * @return
     * The mime
     */
    public String getMime() {
        return mime;
    }

    /**
     *
     * @param mime
     * The mime
     */
    public void setMime(String mime) {
        this.mime = mime;
    }

    /**
     *
     * @return
     * The fileFormat
     */
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     *
     * @param fileFormat
     * The fileFormat
     */
    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    /**
     *
     * @return
     * The image
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}