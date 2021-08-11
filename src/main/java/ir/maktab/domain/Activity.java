package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.domain.enumartion.ActivityStatusType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Activity extends BaseEntity<Integer> {
    private String title;
    private String description;
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private ActivityStatusType statusType;
    private LocalDate startedDate;
    private LocalDate completeDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public ActivityStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(ActivityStatusType statusType) {
        this.statusType = statusType;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(LocalDate completeDate) {
        this.completeDate = completeDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return  getId() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", statusType=" + statusType +
                ", startedDate=" + startedDate +
                ", completeDate=" + completeDate +
                ", user=" + user.getUsername() +
                ']' + "\n";
    }


}
