package luckyclient.jenkinsapi;

import luckyclient.dblog.LogOperation;

public class RestartServerInitialization {

	@SuppressWarnings("finally")
	public static String RestartServerRun(String tastid){
		String result = "Status:true"+" ��������ִ�гɹ���";
		try{
			String[] command = LogOperation.Getrestartcomm(tastid);
			if(command!=null){
				luckyclient.publicclass.LogUtil.APP.info("׼������ָ����TOMCAT�����Եȡ���������������"+command.length);
				if(command.length==5){
					luckyclient.publicclass.LogUtil.APP.info("��ʼ��������TOMCAT��������������0��"+command[0]+" ����1��"+command[1]
							+" ����2��"+command[2]+" ����3��"+command[3]+" ����4��"+command[4]);
					result = RmtShellExecutor.sshShell(command[0], command[1], command[2], Integer.valueOf(command[3]), command[4]);
				}else{
					luckyclient.publicclass.LogUtil.APP.error("����TOMCAT�����в��������쳣������������Ϣ��");
					result = "����TOMCAT�����в��������쳣������������Ϣ��";
				}				
			}else{
				result = "Status:true"+" ��ǰ����û���ҵ���Ҫ������TOMCAT���";
				luckyclient.publicclass.LogUtil.APP.info("��ǰ����û��ָ����Ҫ����TOMCAT��");
			}
		}catch(Throwable e){
			luckyclient.publicclass.LogUtil.APP.error("����TOMCAT�����г����쳣");
			luckyclient.publicclass.LogUtil.APP.error(e.getMessage(),e);
			result = "����TOMCAT�����г����쳣";
		}finally{
			return result;
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestartServerRun("1460");
	}

}