package my.petshop.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import my.petshop.common.MyConstantes;

@Entity
@Table(name = "pets")
public class PetEntity {
	// An autogenerated id (unique for each user in the db)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Category category;
	
	@OneToMany
	@JoinColumn(name = "url")
	private Collection<PhotoUrls> photoUrls;

	@OneToMany
	@JoinColumn(name = "tags")
	private Collection<Tags> tags;

	@NotNull
	@Column(name = "status")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Public methods

	public PetEntity() {
	}

	public PetEntity(long id) {
		this.id = id;
	}

	public PetEntity(Category category, String name) {
		this.category = category;
		this.name = name;
		this.status = MyConstantes.AVAILABLE_STATUS;
	}

	public String toString() {
		return "{id=" + id + ";name=" + name + ";category=" + category + ";status=" + status + "}";
	}

	public Collection<PhotoUrls> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(Collection<PhotoUrls>  photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Collection<Tags> getTags() {
		return tags;
	}

	public void setTags(Collection<Tags> tags) {
		this.tags = tags;
	}
}