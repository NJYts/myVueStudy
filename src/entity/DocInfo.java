package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import util.DateUtil;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
@Table(name = "wise_web_docinfo", uniqueConstraints = { @javax.persistence.UniqueConstraint(columnNames = { "url" }) })
public class DocInfo extends IdEntity {
	private static final long serialVersionUID = 1L;
	private Integer siteId;//网站id
	private String siteName;//网站名字
	private Integer groupId;
	private String url;
	private String urlhash;
	private String title;
	private String author;
	private Integer click;//点击
	private Integer reply;//回复
	private Date publishtime;//发布时间
	private String status;// 停用字段，先用来放微博的赞的数量
	private String position;//位置
	private String keywords;
	private Long keywordsHash;// by sqn
	private Timestamp gathertime;//采集时间
	private Integer gatherId;
	private String rawFile;//raw文件
	private Integer rawOffset;//？
	private Integer rawLength;
	private String txtFile;
	private Integer txtOffset;
	private Integer txtLength;
	private Long inserttime;
	private Integer flag;
	private String content;//内容
	private Long docId;// by sqn
	private Integer repeatCount;// by sqn
	private int crSec;// 弃用字段，后改为头条短信发送后的字段，0为未操作，1为推送头条首页2为短信发送
	private Integer typeId;
	private int tendency; // 倾向性
	private int tendencyFlag; // 数据倾向性的标识
	/** 文章倾向性属性 bdrh */
	private String sen;
	/** 显示时间段sqn */
	private String pubtime;
	private String time;
	/***/
	private Double sec;
	private String imgsrc;
	private Integer hotsign;
	private String addresswords;
	private Float heatValue;// 弃用字段，改为短信推送字段 0 未推送 1推送
	/**
	 * 快照
	 */
	private String snapshot;
	private String summary;
	/**
	 * 
	 * @return
	 */
	private String siteNameSplit;
	/**
	 * 网站描述
	 */
	private String siteDisc;
	/**
	 * 处理标志 1:转载处理 2：推送至首页头条
	 */
	private Integer handleType;
	/** 来源类型：0网智采集器，1人工补录，... */
	private Integer gatherType;

	/** 标题关键词 */
	private String titleSpeech;
	/** 标题关键词 hash值 */
	private Long titlehash;//
	private int code;
	private Integer errorType;

	//private DocInfoCenter docInfoCenter;
	

	@Column(name = "title_speech")
	public String getTitleSpeech() {
		return titleSpeech;
	}

	public void setTitleSpeech(String titleSpeech) {
		this.titleSpeech = titleSpeech;
	}

	@Column(name = "titlehash")
	public Long getTitlehash() {
		return titlehash;
	}

	public void setTitlehash(Long titlehash) {
		this.titlehash = titlehash;
	}

	@Column(name = "doc_id")
	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	@Column(name = "hot_sign")
	public Integer getHotsign() {
		return hotsign;
	}

	public void setHotsign(Integer hotsign) {
		this.hotsign = hotsign;
	}

	/**
	 * 相关文章集合
	 * */
	private List<?> xglist;

	public DocInfo() {
	}

	public DocInfo(Integer siteId, String siteName, Integer groupId,
			String url, String urlhash, String title, String author,
			Integer click, Integer reply, Date publishtime, String status,
			String position, String keywords, Long keywordsHash,
			Timestamp gathertime, Integer gatherId, String rawFile,
			Integer rawOffset, Integer rawLength, String txtFile,
			Integer txtOffset, Integer txtLength, Long inserttime,
			Integer flag, String content, Long docId, Integer repeatCount,
			int crSec, Integer typeId, int tendency, int tendencyFlag,
			String sen, String pubtime, String time, Double sec,
			Integer hotsign, String addresswords, Float heatValue,
			String snapshot, String summary, String siteNameSplit,
			String siteDisc, Integer handleType, Integer gatherType,
			String titleSpeech, Long titlehash, List<?> xglist) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.groupId = groupId;
		this.url = url;
		this.urlhash = urlhash;
		this.title = title;
		this.author = author;
		this.click = click;
		this.reply = reply;
		this.publishtime = publishtime;
		this.status = status;
		this.position = position;
		this.keywords = keywords;
		this.keywordsHash = keywordsHash;
		this.gathertime = gathertime;
		this.gatherId = gatherId;
		this.rawFile = rawFile;
		this.rawOffset = rawOffset;
		this.rawLength = rawLength;
		this.txtFile = txtFile;
		this.txtOffset = txtOffset;
		this.txtLength = txtLength;
		this.inserttime = inserttime;
		this.flag = flag;
		this.content = content;
		this.docId = docId;
		this.repeatCount = repeatCount;
		this.crSec = crSec;
		this.typeId = typeId;
		this.tendency = tendency;
		this.tendencyFlag = tendencyFlag;
		this.sen = sen;
		this.pubtime = pubtime;
		this.time = time;
		this.sec = sec;
		this.hotsign = hotsign;
		this.addresswords = addresswords;
		this.heatValue = heatValue;
		this.snapshot = snapshot;
		this.summary = summary;
		this.siteNameSplit = siteNameSplit;
		this.siteDisc = siteDisc;
		this.handleType = handleType;
		this.gatherType = gatherType;
		this.titleSpeech = titleSpeech;
		this.titlehash = titlehash;
		this.xglist = xglist;
	}

	public DocInfo(Integer siteId, String urlhash, String title,
			Integer gatherId, String rawFile, Integer rawOffset,
			Integer rawLength, String txtFile, Integer txtOffset,
			Integer txtLength, Integer flag) {
		this.siteId = siteId;
		this.urlhash = urlhash;
		this.title = title;
		this.gatherId = gatherId;
		this.rawFile = rawFile;
		this.rawOffset = rawOffset;
		this.rawLength = rawLength;
		this.txtFile = txtFile;
		this.txtOffset = txtOffset;
		this.txtLength = txtLength;
		this.flag = flag;
	}

	public DocInfo(Integer siteId, String siteName, Integer groupId,
			String url, String urlhash, String title, String author,
			Integer click, Integer reply, Date publishtime, String status,
			String position, String keywords, Timestamp gathertime,
			Integer gatherId, String rawFile, Integer rawOffset,
			Integer rawLength, String txtFile, Integer txtOffset,
			Integer txtLength, Long inserttime, Integer flag, Integer hotsign) {
		this.siteId = siteId;
		this.siteName = siteName;
		this.groupId = groupId;
		this.url = url;
		this.urlhash = urlhash;
		this.title = title;
		this.author = author;
		this.click = click;
		this.reply = reply;
		this.publishtime = publishtime;
		this.status = status;
		this.position = position;
		this.keywords = keywords;
		this.gathertime = gathertime;
		this.gatherId = gatherId;
		this.rawFile = rawFile;
		this.rawOffset = rawOffset;
		this.rawLength = rawLength;
		this.txtFile = txtFile;
		this.txtOffset = txtOffset;
		this.txtLength = txtLength;
		this.inserttime = inserttime;
		this.flag = flag;
		this.hotsign = hotsign;
	}

	public DocInfo(Integer siteId, String siteName, Integer groupId,
			String url, String urlhash, String title, String author,
			Integer click, Integer reply, Date publishtime, String status,
			String position, String keywords, Long keywordsHash,
			Timestamp gathertime, Integer gatherId, String rawFile,
			Integer rawOffset, Integer rawLength, String txtFile,
			Integer txtOffset, Integer txtLength, Long inserttime,
			Integer flag, String content, Long docId, int repeatCount,
			int crSec, Integer typeId, String sen, String pubtime, Double sec,
			Integer hotsign, String addresswords, Float heatValue,
			List<?> xglist) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.groupId = groupId;
		this.url = url;
		this.urlhash = urlhash;
		this.title = title;
		this.author = author;
		this.click = click;
		this.reply = reply;
		this.publishtime = publishtime;
		this.status = status;
		this.position = position;
		this.keywords = keywords;
		this.keywordsHash = keywordsHash;
		this.gathertime = gathertime;
		this.gatherId = gatherId;
		this.rawFile = rawFile;
		this.rawOffset = rawOffset;
		this.rawLength = rawLength;
		this.txtFile = txtFile;
		this.txtOffset = txtOffset;
		this.txtLength = txtLength;
		this.inserttime = inserttime;
		this.flag = flag;
		this.content = content;
		this.docId = docId;
		this.repeatCount = repeatCount;
		this.crSec = crSec;
		this.typeId = typeId;
		this.sen = sen;
		this.pubtime = pubtime;
		this.sec = sec;
		this.hotsign = hotsign;
		this.addresswords = addresswords;
		this.heatValue = heatValue;
		this.xglist = xglist;
	}

	public DocInfo(Integer siteId, String siteName, Integer groupId,
			String url, String urlhash, String title, String author,
			Integer click, Integer reply, Date publishtime, String status,
			String position, String keywords, Long keywordsHash,
			Timestamp gathertime, Integer gatherId, String rawFile,
			Integer rawOffset, Integer rawLength, String txtFile,
			Integer txtOffset, Integer txtLength, Long inserttime,
			Integer flag, String content, Long docId, int repeatCount,
			int crSec, Integer typeId, String sen, String pubtime, Double sec,
			Integer hotsign, String addresswords, List<?> xglist) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.groupId = groupId;
		this.url = url;
		this.urlhash = urlhash;
		this.title = title;
		this.author = author;
		this.click = click;
		this.reply = reply;
		this.publishtime = publishtime;
		this.status = status;
		this.position = position;
		this.keywords = keywords;
		this.keywordsHash = keywordsHash;
		this.gathertime = gathertime;
		this.gatherId = gatherId;
		this.rawFile = rawFile;
		this.rawOffset = rawOffset;
		this.rawLength = rawLength;
		this.txtFile = txtFile;
		this.txtOffset = txtOffset;
		this.txtLength = txtLength;
		this.inserttime = inserttime;
		this.flag = flag;
		this.content = content;
		this.docId = docId;
		this.repeatCount = repeatCount;
		this.crSec = crSec;
		this.typeId = typeId;
		this.sen = sen;
		this.pubtime = pubtime;
		this.sec = sec;
		this.hotsign = hotsign;
		this.addresswords = addresswords;
		this.xglist = xglist;
	}

	@Column(name = "type_id")
	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "keywordhash", nullable = false)
	public Long getKeywordsHash() {
		return keywordsHash;
	}

	public void setKeywordsHash(Long keywordsHash) {
		this.keywordsHash = keywordsHash;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "site_name", length = 40)
	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName=siteName;
		
	}

	@Column(name = "group_id")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "url", unique = true, length = 500)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "urlhash", nullable = false)
	public String getUrlhash() {
		return this.urlhash;
	}

	public void setUrlhash(String urlhash) {
		this.urlhash = urlhash;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		//return HtmlTransfer.htmEncode(this.title);
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "author", length = 100)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "click")
	public Integer getClick() {
		return this.click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	@Column(name = "reply")
	public Integer getReply() {
		return this.reply;
	}

	public void setReply(Integer reply) {
		this.reply = reply;
	}

	@Column(name = "publishtime")
	public Date getPublishtime() {
		return this.publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	@Column(name = "status", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "position", length = 100)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "keywords", length = 100)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "gathertime", length = 0)
	public Timestamp getGathertime() {
		return this.gathertime;
	}

	public void setGathertime(Timestamp gathertime) {
		this.gathertime = gathertime;
	}

	@Column(name = "gather_id", nullable = false)
	public Integer getGatherId() {
		return this.gatherId;
	}

	public void setGatherId(Integer gatherId) {
		this.gatherId = gatherId;
	}

	@Column(name = "raw_file", nullable = false, length = 200)
	public String getRawFile() {
		return this.rawFile;
	}

	public void setRawFile(String rawFile) {
		this.rawFile = rawFile;
	}

	@Column(name = "raw_offset", nullable = false)
	public Integer getRawOffset() {
		return this.rawOffset;
	}

	public void setRawOffset(Integer rawOffset) {
		this.rawOffset = rawOffset;
	}

	@Column(name = "raw_length", nullable = false)
	public Integer getRawLength() {
		return this.rawLength;
	}

	public void setRawLength(Integer rawLength) {
		this.rawLength = rawLength;
	}

	@Column(name = "txt_file", nullable = false, length = 200)
	public String getTxtFile() {
		return this.txtFile;
	}

	public void setTxtFile(String txtFile) {
		this.txtFile = txtFile;
	}

	@Column(name = "txt_offset", nullable = false)
	public Integer getTxtOffset() {
		return this.txtOffset;
	}

	public void setTxtOffset(Integer txtOffset) {
		this.txtOffset = txtOffset;
	}

	@Column(name = "txt_length", nullable = false)
	public Integer getTxtLength() {
		return this.txtLength;
	}

	public void setTxtLength(Integer txtLength) {
		this.txtLength = txtLength;
	}

	@Column(name = "inserttime", length = 0)
	public Long getInserttime() {
		return this.inserttime;
	}

	public void setInserttime(Long inserttime) {
		this.inserttime = inserttime;
	}

	@Column(name = "flag", nullable = false)
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Column(name = "repeat_count")
	public Integer getRepeatCount() {
		if (this.repeatCount != 0) {
			return repeatCount;
		} else {
			return 1;
		}
	}

	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}

	@Column(name = "cr_sec")
	public int getCrSec() {
		return crSec;
	}

	public void setCrSec(int crSec) {
		this.crSec = crSec;
	}

	@Column(name = "sec", nullable = false)
	public Double getSec() {
		return sec;
	}

	public void setSec(Double sec) {
		this.sec = sec;
	}

	@Transient
	public String getSen() {
		return sen;
	}

	public void setSen(String sen) {
		this.sen = sen;
	}

	@Transient
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Transient
	public String getPublishtimeString() {
		if (this.publishtime != null && this.publishtime.getTime() > 0) {
			return DateUtil.yyyyMMddHHmmss.format(this.publishtime);
		}
		return "";
	}

	@Transient
	public String getPublishtimeCh() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		return df.format(this.publishtime);
	}

	@Transient
	public String getGathertimeString() {
		return DateUtil.yyyyMMddHHmmss.format(this.gathertime);
	}

	@Transient
	public String getFormatGatherTime() {
		if (this.gathertime != null && this.gathertime.getTime() > 0) {
			return DateUtil.MMddHHmm.format(this.gathertime);
		}
		return "";
	}

	@Transient
	public String getFormatPublishTime() {
		if (this.publishtime != null && this.publishtime.getTime() > 0) {
			return DateUtil.MMddHHmm.format(this.publishtime);
		}
		return "";
	}

	@Transient
	public String getPubtime() {
		String pubtime = "";
		int htime = 0;
		int mitime = 0;
		SimpleDateFormat simpledate = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		if (this.publishtime != null && !"".equals(this.publishtime))
			try {
				Long endTime = (System.currentTimeMillis() - simpledate.parse(
						simpledate.format(this.publishtime)).getTime()) / 60000;
				int etime = Integer.valueOf(endTime.toString());
				htime = etime / 60;
				mitime = etime % 60;
				if (this.publishtime.getTime() > System.currentTimeMillis()) {
					pubtime = "N/A";
				} else if (htime > 24) {
					pubtime = simpledate.format(this.publishtime);
				} else if (htime != 0) {
					pubtime = pubtime + htime + "小时以前";
				} else if (mitime != 0) {
					pubtime = pubtime + mitime + "分钟以前";
				} else {
					pubtime = "刚刚";
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	@Transient
	public List getXglist() {
		return xglist;
	}

	public void setXglist(List xglist) {
		this.xglist = xglist;
	}

	@Column(name = "addresswords")
	public String getAddresswords() {
		return addresswords;
	}

	public void setAddresswords(String addresswords) {
		this.addresswords = addresswords;
	}

	@Column(name = "heat_value", nullable = false, precision = 10)
	public Float getHeatValue() {
		if (this.heatValue == null) {
			this.heatValue = Float.valueOf(0.00F);
		}
		return heatValue;
	}

	public void setHeatValue(Float heatValue) {
		this.heatValue = heatValue;
	}

	@Column(name = "site_disc")
	public String getSiteDisc() {
		return siteDisc;
	}

	public void setSiteDisc(String siteDisc) {
		this.siteDisc = siteDisc;
	}

	@Transient
	public String getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}

	@Transient
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Transient
	public String getSiteNameSplit() {
		if (this.siteName != null && !this.siteName.equals("")) {
			if (this.siteName.indexOf("_") > -1) {
				this.siteNameSplit = this.siteName.split("_")[0];
			} else if(this.siteName.indexOf("-") > -1){
				this.siteNameSplit = this.siteName.split("-")[0];
			}else {
				this.siteNameSplit = this.siteName;
			}
		}
		return siteNameSplit;
	}

	public void setSiteNameSplit(String siteNameSplit) {
		this.siteNameSplit = siteNameSplit;
	}

	@Column(name = "handle_type")
	public Integer getHandleType() {
		if (this.handleType == null) {
			this.handleType = 0;
		}
		return handleType;
	}

	public void setHandleType(Integer handleType) {
		this.handleType = handleType;
	}

	@Transient
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "gather_type")
	public Integer getGatherType() {
		if (this.gatherType == null) {
			this.gatherType = 0;
		}
		return this.gatherType;
	}

	public void setGatherType(Integer gatherType) {
		this.gatherType = gatherType;
	}

	@Column(name = "tendency")
	public int getTendency() {
		return tendency;
	}

	public void setTendency(int tendency) {
		this.tendency = tendency;
	}

	@Column(name = "tendency_flag")
	public int getTendencyFlag() {
		return tendencyFlag;
	}

	public void setTendencyFlag(int tendencyFlag) {
		this.tendencyFlag = tendencyFlag;
	}

	@Transient
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	@Transient
	public String getPublishTimeFormat() {
		if (this.publishtime != null && this.publishtime.getTime() > 0) {
			return DateUtil.yyyyMMddHHmmss.format(this.publishtime);
		}
		return null;
	}

	@Transient
	public String getGatherTimeFormat() {
		if (this.gathertime != null && this.gathertime.getTime() > 0) {
			return DateUtil.yyyyMMddHHmmss.format(this.gathertime);
		}
		return null;
	}
	@Transient
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	@Transient
	public Integer getErrorType() {
		return errorType;
	}

	public void setErrorType(Integer errorType) {
		this.errorType = errorType;
	}

/*	@OneToOne
	@JoinColumn(name = "doc_info_id")
	public DocInfoCenter getDocInfoCenter() {
		return docInfoCenter;
	}

	public void setDocInfoCenter(DocInfoCenter docInfoCenter) {
		this.docInfoCenter = docInfoCenter;
	}
	@Formula("(SELECT w.id FROM wise_web_docinfo_center AS w WHERE w.id = id)")
	public Long getDocInfoCenterId(){
		return docInfoCenterId;
	}
	
	public void setDocInfoCenterId(Long docInfoCenterId){
		this.docInfoCenterId = docInfoCenterId;
	}*/
	
}
