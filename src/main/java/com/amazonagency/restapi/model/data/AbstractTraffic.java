package com.amazonagency.restapi.model.data;

import lombok.Data;

@Data
public abstract class AbstractTraffic {
    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;

    public AbstractTraffic add(AbstractTraffic other) {
        this.browserSessions += other.browserSessions;
        this.browserSessionsB2B += other.browserSessionsB2B;
        this.mobileAppSessions += other.mobileAppSessions;
        this.mobileAppSessionsB2B += other.mobileAppSessionsB2B;
        this.sessions += other.sessions;
        this.sessionsB2B += other.sessionsB2B;
        this.browserPageViews += other.browserPageViews;
        this.browserPageViewsB2B += other.browserPageViewsB2B;
        this.mobileAppPageViews += other.mobileAppPageViews;
        this.mobileAppPageViewsB2B += other.mobileAppPageViewsB2B;
        this.pageViews += other.pageViews;
        this.pageViewsB2B += other.pageViewsB2B;

        return this;
    }
}
