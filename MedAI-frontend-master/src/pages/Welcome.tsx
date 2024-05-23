import { IMAGES } from '@/constants';
import { createFromIconfontCN } from '@ant-design/icons';
import { PageContainer } from '@ant-design/pro-components';
import { Alert, Card, Carousel, Divider, Image, Typography } from 'antd';
import React, { useEffect, useState } from 'react';

/**
 * 每个单独的卡片，为了复用样式抽成了组件
 */
const { Title, Paragraph } = Typography;

const MyIcon = createFromIconfontCN({
  scriptUrl: '//at.alicdn.com/t/c/font_4064432_4snwg02llsf.js', // 在 iconfont.cn 上生成
});

const BIIntroduce = `"MedAI+" 融合人工智能和大数据技术，通过数字化手段为临床医生提供更为准确和全面的诊疗依据，推动疾病诊疗水平的持续提升；为患者提供个性化诊疗方案和健康管理，让患者享受到更加便捷和专业的诊疗服务。
`;
const Welcome: React.FC = () => {
  // 加载图片
  const [loadedImages, setLoadedImages] = useState([]);
  useEffect(() => {
    Promise.all(IMAGES)
      // @ts-ignore
      .then((images) => setLoadedImages(images))
      .catch((error) => console.error(error));
  }, []);

  return (
    <PageContainer>
      <Card>
        <Alert
          message={'欢迎使用 "MedAI+" 平台'}
          type="success"
          showIcon
          banner
          style={{
            margin: -12,
            marginBottom: 48,
          }}
        />
        <Typography.Title
          level={2}
          style={{
            textAlign: 'center',
          }}
        >
          {/*<MyIcon type={'icon-maomaochushou'} /> 智能 BI 分析平台{' '}*/}
          {/*<MyIcon type={'icon-Artboard'} />*/}
          {/*修改*/}
          "MedAI+" 数据智能平台

        </Typography.Title>
        <Paragraph>
          {/*我们的智能BI平台是一个革命性的数据分析工具，为用户提供了轻松、快速且智能化的数据分析体验。*/}
          "MedAI+" (Medical Artificial Intelligence Plus) 是针对患者及患病风险人群打造的数字智能平台—MedAI+数字健康平台项目。

        </Paragraph>
        <Title level={3}>平台简介</Title>
        <Paragraph>
          <pre style={{ backgroundColor: '#d2d2d2', color: 'black' }}>{BIIntroduce}</pre>
        </Paragraph>
        <Title level={3}>平台特点</Title>
        <Paragraph>
          1.
          自动化数据分析：项目采用AI技术，能够自动化地从原始数据中生成符合要求的图表和分析结论。用户只需要输入分析目标和原始数据，无需具备专业的数据分析知识，即可完成数据分析的过程。
          <br />
          2.
          节约人力成本：传统的数据分析通常需要数据分析师具备一定的技能和经验，并花费大量的时间进行数据清洗、转化和分析。这个项目的优势在于能够大幅度降低人工数据分析成本，让不具备数据分析能力的用户也能迅速完成数据分析任务，节约了人力资源。
          <br />
          3.
          简化操作流程：该项目提供了图表管理和异步生成的功能，使用户能够更加方便地管理和保存生成的图表，同时异步生成功能也能提升用户的操作效率。
          <br />
          4.
          可视化结果：通过使用AI接口生成分析结果，该项目能够实现将数据以可视化的方式展示出来，使用户更容易理解和解读数据，从而做出更明智的决策。
          <br />
          5.
          适用范围广：由于项目能够从最原始的数据集中进行分析，因此适用于各类行业和领域。用户只需要提供自己的数据和分析目标，即可快速得到相应的分析结果。
        </Paragraph>
        <br />
        <Divider style={{ color: 'blue' }}>AIGC 数据分析</Divider>
        <div style={{ marginLeft: '25px' }}>
          <Carousel autoplay autoplaySpeed={10000}>
            {loadedImages.map((image, index) => (
              <div key={index}>
                <Image src={image.default} />
              </div>
            ))}
          </Carousel>
        </div>
      </Card>
    </PageContainer>
  );
};

export default Welcome;
