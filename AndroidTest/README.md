����
	ֻ�ж��������ܽᣬ���ںϣ��Ż��������
	-------------------------------------------------------------------------------------------	
	���֮ǰ����Ŀ���Լ�дһ�����ֵ�С�Ϳ�ܣ���Ҳ���Լ���ϰ����õķ�ʽ��
		Ҫ��ע��д��Ҫ�ǳ���ϸ�������������Ҫ�ߣ�����Ӧ�ü̳й�ϵ�����ɶ��Ըߣ�����Ľ����ԣ����Ӧ��������������߼���������ô���Ҫ�ߡ�ע�����������׼ȷ��������������
		���棺Ҫ��ÿ��������Ƶļ�࣬�󷽣�������ʽҪ��ѭһ�ָ�ʽ��
			����ͷ�ļ������뷽ʽ�����أ�ÿ�����µĽ��治ͬ���ֵ���ʾ���⣬
				���ʵ��ͷ�ļ��Ĵ���ֻдһ�飬������activity��ֵ����
			
		���ϵ�¼���棺����һ�����⣿�����Ϻ�Ľ��棬��¼�󲻻�ˢ�½��棬�������뷨�޷����أ���Ҫ�����߳��н��С�
			
			��¼���棺�������е���ʱ���¶�̬���֣�������һ����ʱ��������������
				�������⣺��ô�Ͳ���ʾ������ˣ�
				ԭ����super.onMeasure(widthMeasureSpec, heightMeasureSpec)����ǰ���ˣ��Ƿ���������ִ�е�;�ػ�ؼ��Ŀ��Ⱥ͸߶ȣ�
				�Ҳ²⣺��Ҫ�����ڵ��ø�������²���ʱ�ѿ��ߴ���ȥ����Ҳ�����������˵��ø���Ĺ��췽����ʱ��������ʱ������
				��LoginActivity�е�onResume()�����ӷ�������������ؼ��Ĵ�С
				getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE| WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
			�����棺����Ӧ�ĸ߶��������������,Ч��԰�������ҳ������dimen.xml,��
				Android����
				�������
				android�ؼ�
				�߼�Ӧ��
				��ܲ�
				�ײ�����
				
				
		BaseAcitvity:
			4.0������Ҫ�����Ĵ���
			initView(){
				loadViewLayout();	//����ҳ�沼���ļ�
				findViewByid();		//��ʼ���ؼ�
				processLogic();		//�����߼�
				updateUI();			//���½���
			}
			���洢�豸��״̬
			onKeyDown���ؼ�
			
		commonUtil:�����ࣨ�����Ķ��壬�����Ĺ淶��
			������ӡ��־
			���Ķ�ȡ
			
	-------------------------------------------------------------------------------------------	����ģ����ܽ�(֪ʶ����ܽ�)
	Ҫ������ʲô���⣬��ʱ�������������ˡ�	
	1.�����ļ�
		1)sd�����ж�sd����״̬
		2)rom	ֱ�Ӵ洢��ϵͳ��
		3)���ж�sd�������ã��Զ�����rom��
	�ܽ᣺
		�洢�ļ���rom��sd��������
		Rom�У��Ǵ��ڴ��ж�ȡ��д��ģ���Ҫ�����������ڴ棬����
				FileOutputStream outstream = context.openOutputStream(filename);
				FileInputStream instream = context.openInputStream(filename);(���ڶ�ȡ��ʱ���������������һֱû�ж�ȡ�ɹ�)
		SD�У��ֻ������豸���������豸�Ƿ���ã������ò��ɵ�����������ã��洢��·��Ϊ��·����
			Environment.getExternalState.equals(Environment.MEDIA_MOUTED);
			EnVironment.getExternalStorageDirectory().getAbsolutePath()
		Ϊʲô�洢��Rom��ʱ�򣬷���ΪStatic��ʱ��ͻᱨ����
			������Թ��ö�Σ����ǲ�֪��Ϊʲô�����������������˺����Ƶġ�
		new String() �� toString()����������
			java���󶼼̳���Object��Object���ṩ��toString���������ڼ򵥷��ظ������ǩ������Java�У�����Ҳ���Կ�����һ�ֶ���
			��Ȼbyte[]Ҳ��һ�ּ̳���Object�Ķ��󣬲�����û����дObject��toString���������ʹ��byte[]��toString���ص��ַ���Ҳ
			����byte[]����ǩ��������ʹ��new String()���췽����byte[]ת��Ϊ�ַ����õ��ľͻ���һ�������ֽ��������ݹ�����ַ�����
	-------------------------------------------------------------------------------------------			
	2.ƫ�����ã�SharedPreference
		���棬�û��������룬�������ΪĬ��ֵ
				
	-------------------------------------------------------------------------------------------			
			
	3.����ѧϰ�����Ժ��Ӧ���У���selector,animation�����ϣ�
		Activity���������ڷ�Ϊ���㣺
			��һ�㣺�����������ڣ�  onPause --> onResume -- onPause
			�ڶ��㣺�����������ڣ�  onRestart --> onStart--> onResume -->onpause -->onStop
			������������ : onCreate-->onstart-->onresume-->onpause-->onstop-->ondestroy 
			
			
			
	---------------------------------------------------------------------------------------------		
			
	4.�Զ���Activity֮����ת�Ķ���Ч����
	
	/***��ȡ����������
	ActivityUtil.startActivity(LoginActivity.this,new Intent(LoginActivity.this,ViewPagerIndicator.class),getString(R.string.android_basis));
	***/
	
	�Զ����  res/anim/   ��Ļ�Ŀ���x�ᣬ��Ļ�ĸ���y��  
	  	push_in_right   100%p
	  	push_out_left	  -100%p	
	 enterAnim ʱ���ã�
	 overridePendingTransition(R.anim.push_in_right, R.anim.push_out_left);
	 
	 ��Ϊfinish()ִ������ã�
      exitAnim ʱ���ã�overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);     
     	overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);		
                    ��������Ϊϵͳ�Ķ���Ч��   
         Ϊ�˱���StartActivity���Instance,�������ַ�ʽ��
         Intent intent = new Intent(getActivity(), SlideItemFragment.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			getActivity().overridePendingTransition(R.anim.push_in_right, R.anim.push_out_left);
			
			
			
			
			
			
			
					