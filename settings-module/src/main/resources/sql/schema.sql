DROP DATABASE IF EXISTS melon;
CREATE DATABASE IF NOT EXISTS melon;

USE melon;

DROP TABLE IF EXISTS user;
#用户信息表
CREATE TABLE IF NOT EXISTS user (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
  user_name VARCHAR(300) NOT NULL COMMENT '用户名',
  nick_name VARCHAR(300) COMMENT '昵称',
  password VARCHAR(300) NOT NULL COMMENT '密码',
  salt VARCHAR(300) NOT NULL COMMENT '密码加密盐',
  post VARCHAR(30) COMMENT '职务',
  title VARCHAR(30) COMMENT '职称',
  phone VARCHAR(20) COMMENT '手机号码',
  email VARCHAR(50) COMMENT '邮箱',
  locked SMALLINT NOT NULL DEFAULT 1 COMMENT '用户状态，1表示正常，其他表示禁用',
  photo_url VARCHAR(300) COMMENT '头像存放路径',
  self_introduction VARCHAR(500) COMMENT '个人简介',
  residence_address VARCHAR(200) COMMENT '户籍地址',
  current_address VARCHAR(200) COMMENT '当前所在地',
  time_of_entry DATETIME NOT NULL DEFAULT now() COMMENT '参加工作时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY(id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户信息表';

DROP TABLE IF EXISTS resume;
CREATE TABLE IF NOT EXISTS resume (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  user_id BIGINT NOT NULL COMMENT '简历所属用户Id',
  name VARCHAR(50) NOT NULL COMMENT '姓名',
  resume_photo_url VARCHAR(300) COMMENT '简历照片存放路径',
  sex SMALLINT NOT NULL DEFAULT 0 COMMENT '性别，默认为0,0表示男，1表示女',
  marital_status SMALLINT NOT NULL DEFAULT 0 COMMENT '婚姻状况,0表示已婚，1表示未婚',
  political_status INT NOT NULL DEFAULT 0 COMMENT '政治面貌，默认0，表示群众',
  nation VARCHAR(30) DEFAULT '汉族' COMMENT '民族',
  degree_of_education int DEFAULT 0
  COMMENT '文化程度，0表示无，1表示小学，2表示初中，3表示高中，4表示本科，5表示中专，6表示大专，7表示硕士研究生，8表示博士',
  academic_degree int DEFAULT 0 COMMENT '学位，0表示无，1表示小学，2表示初中，3表示高中，4表示学士，5表示中专，6表示大专，7表示硕士，8表示博士',
  phone VARCHAR(20) COMMENT '手机号码',
  email VARCHAR(50) COMMENT '邮箱',
  interest_and_hobbies VARCHAR(500) COMMENT '个人兴趣爱好',
  is_latest SMALLINT NOT NULL DEFAULT 0 COMMENT '是否为最新简历，默认为0，表示不是最新简历，1表示是最新简历',
  birthday DATETIME NOT NULL DEFAULT now() COMMENT '出生日期',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '个人简历表';

DROP TABLE IF EXISTS educational_experience;
CREATE TABLE IF NOT EXISTS educational_experience (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  resume_id BIGINT NOT NULL COMMENT '所属简历Id',
  graduate_institutions VARCHAR(30) COMMENT '毕业院校',
  major VARCHAR(30) COMMENT '所学专业',
  year_of_major SMALLINT COMMENT '专业学制',
  research_description VARCHAR(300) COMMENT '研究方向描述',
  reterence VARCHAR(30) COMMENT '证明人',
  start_time DATETIME NOT NULL COMMENT '起始时间',
  end_time DATETIME NOT NULL COMMENT '结束时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '教育经历表';

DROP TABLE IF EXISTS work_experience;
CREATE TABLE IF NOT EXISTS work_experience (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  resume_id BIGINT NOT NULL COMMENT '所属简历Id',
  company VARCHAR(50) COMMENT '工作公司或单位',
  address VARCHAR(100) COMMENT '工作地址',
  jop_position VARCHAR(50) COMMENT '工作职位',
  description VARCHAR(300) COMMENT '工作职位描述',
  reterence VARCHAR(30) COMMENT '证明人',
  start_time DATETIME NOT NULL DEFAULT now() COMMENT '工作起始时间',
  end_time DATETIME NOT NULL DEFAULT now() COMMENT '工作结束时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE = InnoDB DEFAULT  CHARSET = utf8 COMMENT '工作经历表';

DROP TABLE IF EXISTS school_reward;
CREATE TABLE IF NOT EXISTS school_reward (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  resume_id BIGINT NOT NULL COMMENT '所属简历Id',
  reward VARCHAR(100) COMMENT '奖励名称',
  address VARCHAR(100) COMMENT '获奖地点',
  reterence VARCHAR(30) COMMENT '获奖证明人',
  start_time DATETIME NOT NULL DEFAULT now() COMMENT '起始时间',
  end_time DATETIME NOT NULL DEFAULT now() COMMENT '截止时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '个人在校奖励信息表';

DROP TABLE IF EXISTS school_activities;
CREATE TABLE IF NOT EXISTS school_activities (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  resume_id BIGINT NOT NULL COMMENT '所属简历Id',
  activity_description VARCHAR(300) COMMENT '活动描述',
  reterence VARCHAR(30) COMMENT '活动证明人',
  start_time DATETIME NOT NULL DEFAULT now() COMMENT '起始时间',
  end_time DATETIME NOT NULL DEFAULT now() COMMENT '截止时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '个人在校参与的社交活动信息表';

DROP TABLE IF EXISTS internship_experience;
CREATE TABLE IF NOT EXISTS internship_experience (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  resume_id BIGINT NOT NULL COMMENT '所属简历Id',
  responsibility_description VARCHAR(500) COMMENT '实习职责描述',
  company VARCHAR(50) NOT NULL COMMENT '实习公司或单位',
  address VARCHAR(100) COMMENT '实习地址',
  reterence VARCHAR(30) COMMENT '实习证明人',
  start_time DATETIME NOT NULL DEFAULT now() COMMENT '起始时间',
  end_time DATETIME NOT NULL DEFAULT now() COMMENT '截止时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '个人实习经历信息表';

DROP TABLE IF EXISTS family_relationship;
CREATE TABLE IF NOT EXISTS family_relationship (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  user_id BIGINT NOT NULL COMMENT '用户Id',
  relationship VARCHAR(30) COMMENT '与当事人关系',
  name VARCHAR(50) COMMENT '姓名',
  degree_of_education SMALLINT DEFAULT 0 COMMENT '文化程度',
  job VARCHAR(30) COMMENT '工作',
  phone VARCHAR(30) COMMENT '联系方式',
  birthday DATETIME NOT NULL DEFAULT now() COMMENT '出生日期',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '个人家庭状况表';

DROP TABLE IF EXISTS company;
CREATE TABLE IF NOT EXISTS company (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  name VARCHAR(50) NOT NULL COMMENT '公司名称',
  founder VARCHAR(30) COMMENT '公司创始人',
  business_type VARCHAR(50) COMMENT '公司经营类型',
  address VARCHAR(200) NOT NULL COMMENT '公司地址',
  registered_assets VARCHAR(20) COMMENT '公司注册资产',
  introduction VARCHAR(500) COMMENT '公司简介',
  email VARCHAR(30) COMMENT '公司联系邮箱',
  phone VARCHAR(30) COMMENT '公司联系电话',
  listed SMALLINT NOT NULL DEFAULT 0 COMMENT '是否上市，默认为0 ，表示没上市， 1表示上市',
  create_time DATETIME NOT NULL DEFAULT now() COMMENT '公司创办时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '公司信息表';

DROP TABLE IF EXISTS department;
CREATE TABLE IF NOT EXISTS department (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  company_id BIGINT NOT NULL COMMENT '所属公司Id',
  header_id BIGINT NOT NULL COMMENT '部门负责人Id',
  name VARCHAR(50) NOT NULL COMMENT '部门名称',
  introduction VARCHAR(300) COMMENT '部门简介',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (company_id) REFERENCES company (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '公司部门信息表';

DROP TABLE IF EXISTS project_group;
CREATE TABLE IF NOT EXISTS project_group (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  group_leader_id BIGINT NOT NULL COMMENT '项目组组长Id',
  department_id BIGINT NOT NULL COMMENT '项目组所属部门Id',
  name VARCHAR(30) NOT NULL COMMENT '项目组名称',
  reposibility VARCHAR(300) COMMENT '项目组主要职责',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (department_id) REFERENCES department (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '部门项目组信息表';

DROP TABLE IF EXISTS project_group_member;
CREATE TABLE IF NOT EXISTS project_group_member (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  member_id BIGINT NOT NULL COMMENT '用户Id',
  project_group_id BIGINT NOT NULL COMMENT '项目组Id',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户、项目组管理表';

DROP TABLE IF EXISTS project;
CREATE TABLE IF NOT EXISTS project (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  department_id BIGINT NOT NULL COMMENT '项目所属部门Id',
  number VARCHAR(100) NOT NULL COMMENT '项目编号',
  employe_name VARCHAR(100) COMMENT '项目甲方公司名称',
  name VARCHAR(200) NOT NULL COMMENT '项目名称',
  type_id BIGINT NOT NULL COMMENT '项目类型Id',
  start_time DATETIME NOT NULL DEFAULT now() COMMENT '项目起始日期',
  end_time DATETIME NOT NULL DEFAULT now() COMMENT '项目截止日期',
  total_funds DOUBLE COMMENT '项目总经费',
  contract_amount DOUBLE COMMENT '项目合同额',
  soft INT DEFAULT 0 COMMENT '预期成果 软件数量',
  report INT DEFAULT 0 COMMENT '预期成果 报告数量',
  standard INT DEFAULT 0 COMMENT '预期成果 标准数量',
  article INT DEFAULT 0 COMMENT '预期成果 论文数量',
  patent INT DEFAULT 0 COMMENT '预期成果 专利数量',
  software_works INT DEFAULT 0 COMMENT '预期成果 软件著作数量',
  progress INT DEFAULT 0 COMMENT '项目完成进度，1到10分别表示可研、评审、出库、投标、合同、1阶段、2阶段、3阶段、验收以及维护这10个项目进度阶段',
  progress_situation SMALLINT DEFAULT 0 COMMENT '项目进度各阶段完成情况，0表示未开始，1表示正在进行中，2表示已完成',
  owner_group_id BIGINT NOT NULL COMMENT '项目负责组Id',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (department_id) REFERENCES department (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '项目信息表';

DROP TABLE IF EXISTS project_type;
CREATE TABLE IF NOT EXISTS project_type (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  name VARCHAR(200) NOT NULL COMMENT '项目类型名称',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  description VARCHAR(500) COMMENT '描述',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '项目类型';

DROP TABLE IF EXISTS project_member;
CREATE TABLE IF NOT EXISTS project_member (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  project_id BIGINT NOT NULL COMMENT '项目Id',
  member_id BIGINT NOT NULL COMMENT '项目成员Id',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '项目成员关联表';

DROP TABLE IF EXISTS project_company;
CREATE TABLE IF NOT EXISTS project_company (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  project_id BIGINT NOT NULL COMMENT '项目Id',
  company_id BIGINT NOT NULL COMMENT '公司Id',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '项目与合作公司关联关系表';

DROP TABLE IF EXISTS project_department;
CREATE TABLE IF NOT EXISTS project_department (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  project_id BIGINT NOT NULL COMMENT '项目Id',
  department_id BIGINT NOT NULL COMMENT '部门Id',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '项目与合作部门关联关系表';

DROP TABLE IF EXISTS task;
CREATE TABLE IF NOT EXISTS task (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  title VARCHAR(300) NOT NULL COMMENT '任务标题',
  detail TEXT COMMENT '任务详情',
  assigner_id BIGINT NOT NULL COMMENT '任务指派人Id',
  receiver_id BIGINT NOT NULL COMMENT '任务接收人Id',
  status SMALLINT NOT NULL DEFAULT 0 COMMENT '任务完成状况，0表示未开始，1表示进行中，2表示已完成',
  deadline DATETIME NOT NULL DEFAULT now() COMMENT '任务最后完成截止时间',
  actual_finish_time DATETIME NOT NULL DEFAULT now() COMMENT '任务时间完成时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '任务信息表';

DROP TABLE IF EXISTS weekly;
CREATE TABLE IF NOT EXISTS weekly (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  report_time DATETIME NOT NULL DEFAULT now() COMMENT '填报时间',
  reporter_id BIGINT NOT NULL COMMENT '周报条保人Id',
  group_id BIGINT NOT NULL COMMENT '所属项目组Id',
  position_type INT NOT NULL DEFAULT 0 COMMENT '岗位类型，0表示管理，1表示研发，2表示技术，3表示商务',
  project_id BIGINT NOT NULL COMMENT '项目Id',
  task_type SMALLINT NOT NULL DEFAULT 0 COMMENT '任务类型，0表示计划任务，1表示非计划任务',
  plan_finish_task TEXT COMMENT '计划完成任务',
  task_rank SMALLINT NOT NULL DEFAULT 1 COMMENT '任务等级，1表示紧急，2表示重要，3表示一般，4正常',
  task_deadline DATETIME COMMENT '任务完成截止时间',
  plan_invest_time DOUBLE COMMENT '计划投入时间',
  actual_finish_task TEXT COMMENT '实际完成任务',
  normal_time DOUBLE COMMENT '正常上班时长',
  overtime DOUBLE COMMENT '加班时长',
  checked VARCHAR(100) COMMENT '周报校核',
  audit VARCHAR(100) COMMENT '审核',
  finish_estimate VARCHAR(100) COMMENT '完成评估',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY (id),
  FOREIGN KEY (reporter_id) REFERENCES user (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '周报表';

#用户角色表
DROP TABLE IF EXISTS role;
CREATE TABLE IF NOT EXISTS role (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '角色唯一标识ID',
  name VARCHAR(200) NOT NULL COMMENT '角色名称',
  description VARCHAR(300) COMMENT '角色描述',
  available SMALLINT DEFAULT 0 COMMENT '是否可用，0:表示不可用，1:表示可用',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户角色表';

#权限表
DROP TABLE IF EXISTS permission;
CREATE TABLE IF NOT EXISTS permission (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '资源唯一标识ID',
  parent_id BIGINT COMMENT '父级菜单Id',
  parent_ids VARCHAR(300) COMMENT '父级编号列表',
  name VARCHAR(200) NOT NULL COMMENT '资源名称',
  icon VARCHAR(100) DEFAULT '' COMMENT '图标',
  type INT COMMENT '资源类型，1表示菜单(menu)，2表示连接地址(url)，3表示按钮(button)',
  url VARCHAR(300) COMMENT '资源路径',
  permission VARCHAR(500) COMMENT '权限字符串,如,user,role:*,按钮,button:create..',
  available SMALLINT DEFAULT 1 COMMENT '是否可用,默认为1,0:禁用，1:表示可用',
  sort INT DEFAULT 1 COMMENT '权限资源排序',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户权限表';

#用户、角色关联表
DROP TABLE IF EXISTS user_role;
CREATE TABLE IF NOT EXISTS user_role (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
  user_id BIGINT NOT NULL COMMENT '用户唯一标识ID',
  role_id BIGINT NOT NULL COMMENT '角色唯一标识ID',
  description VARCHAR(500) COMMENT '描述',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户角色关联表';

#角色、权限关联表
DROP TABLE IF EXISTS role_permission;
CREATE TABLE IF NOT EXISTS role_permission (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
  role_id BIGINT NOT NULL COMMENT '角色唯一标识ID',
  permission_id BIGINT NOT NULL COMMENT '权限唯一标识ID',
  description VARCHAR(500) COMMENT '描述',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户角色权限关联表';