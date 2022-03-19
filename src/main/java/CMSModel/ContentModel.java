package CMSModel;

import java.util.Date;

public class ContentModel {
	private int id;
	private String title;
	private String brief;
	private String content;
	private String description;
	private Date createdate;
	private Date updatetime;
	private UserModel user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ContentModel(int id, String title, String brief, String content, Date createdate, Date updatetime,
						UserModel user) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdate = createdate;
		this.updatetime = updatetime;
		this.user = user;
	}
	public ContentModel(String title, String brief, String content, Date createdate, Date updatetime, UserModel user) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdate = createdate;
		this.updatetime = updatetime;
		this.user = user;
	}
	public ContentModel() {
		super();
	}
	@Override
	public String toString() {
		return "ContentModel [id=" + id + ", title=" + title + ", brief=" + brief + ", content=" + content
				+ ", createdate=" + createdate + ", updatetime=" + updatetime + ", user=" + user + "]";
	}
	
	
}
