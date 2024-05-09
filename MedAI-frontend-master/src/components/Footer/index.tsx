import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import '@umijs/max';
import React from 'react';
import {CSDN_LINK, WELCOME} from "@/constants";
const Footer: React.FC = () => {
  const defaultMessage = 'MedAI+';
  const currentYear = new Date().getFullYear();
  const beian = 'xxx';  // 桂ICP备2023002099号
  const beianUrl = 'https://beian.miit.gov.cn/#/Integrated/index';
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      // @ts-ignore
      copyright={
        <>
          {currentYear} {defaultMessage} |{' '}
          <a href={beianUrl} target="_blank" rel="noreferrer">
            {beian}
          </a>
        </>
      }
      links={[
        {
          key: '欢迎使用 MedAI+ ',
          title: '医疗智能',
          href: WELCOME,
          blankTarget: true,
        },
        {
          key: '"MedAI+" 数据智能平台',
          title: '"MedAI+" 数据智能平台',
          href: CSDN_LINK,
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/LaiChuxiao',  // https://github.com/kongshier
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
